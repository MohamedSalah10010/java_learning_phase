/*
🧾 3. To-Do List (Mini CLI App)
Goal: Learn how to manage dynamic data and interact with users in loops.
Features:
1- Add new tasks
2- View all tasks
3- view specific task
4- edit task
5- Mark task as done
6- Mark task as undone
7- Delete task
8- Exit program

Concepts Practiced:

ArrayList, loops, switch, methods, possibly file writing to save data.*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class ToDoList
{
     static ArrayList<ArrayList<String>> DB = new ArrayList<>();
    static int ID ;


    public static void init_ToDoList()
{
    // Load
    Gson task_JSON= new Gson();
    try (Reader reader = new FileReader("data.json")) {
        DB = task_JSON.fromJson(reader, ArrayList.class);
//        System.out.println(DB);
    }catch (IOException e) {
        e.printStackTrace();
    }
    if(DB == null || DB.isEmpty()) {
        ID=1;
        DB= new ArrayList<>();
    }
    else
    {
        ID = Integer.parseInt(DB.getLast().getFirst());
        ID++;
    }


}
public static void edit_task(int id, ArrayList<String> edited_task)
{
    --id;
    DB.get(id).set(1,edited_task.get(0));
    DB.get(id).set(2,edited_task.get(1));
//    DB.get(id).set(3,edited_task.get(2));
}
public static void add_Task(String description, LocalDate dueDate, Boolean status)
{

    ArrayList<String> newTask=new ArrayList<>();
    newTask.add(Integer.toString(ID));
    ID++;
    newTask.add(description);
    newTask.add(dueDate.toString());
    newTask.add(status.toString());

    DB.add(newTask);
}
public static void view_allTasks()
{
    for(var task :DB)
    {
        System.out.println(task);
    }
}
public static void view_Task(int id)
{
        --id;
        var task=DB.get(id);
        System.out.print("Task ID: "+task.get(0)+" , ");
        System.out.print("Task Description: "+task.get(1)+ " , ");
        System.out.print("Task Due Date: "+task.get(2)+ " , ");
        System.out.print("Task Status: "+task.get(3)+ " .");
    }
public static void mark_Task_Done(int id)
{
        --id;
         DB.get(id).set(3, String.valueOf(true));

}
public static void mark_Task_UNDone(int id)
{
        --id;
        DB.get(id).set(3, String.valueOf(false));

}
public static void delete_Task(int id)
{
    --id;
    DB.remove(id);
}
public static void save()
{
    Gson task_JSON= new Gson();
    // Save
    try (FileWriter writer = new FileWriter("data.json")) {
        task_JSON.toJson(DB, writer);
    }catch (IOException e) {
        e.printStackTrace();
    }



}
public static void reset()
{
    init_ToDoList();
    DB.clear();
    save();
    view_allTasks();
}
public static void dummy()
{
    init_ToDoList();
    add_Task("Finish the code of ToDoList", LocalDate.parse("2025-11-01"),false);
    add_Task("Commit the structure of ToDoList", LocalDate.parse("2025-10-29"),true);
    add_Task("Push the structure of ToDoList", LocalDate.parse("2025-10-30"),false);
    add_Task("continue the work with ToDoList", LocalDate.parse("2025-10-28"),false);
    add_Task("Review code formatting in ToDoList", LocalDate.parse("2025-11-03"), false);
    add_Task("Test file saving and loading features", LocalDate.parse("2025-10-31"), true);
    add_Task("Fix null pointer exceptions in ToDoList", LocalDate.parse("2025-11-02"), false);
    add_Task("Add search feature to ToDoList", LocalDate.parse("2025-11-04"), false);
    add_Task("Write documentation for ToDoList project", LocalDate.parse("2025-11-05"), false);
    add_Task("Prepare final presentation for ToDoList", LocalDate.parse("2025-11-06"), true);
    save();
    view_allTasks();
}
public static void Start_ToDoList()
{
    System.out.println("Welcome to my humble To DO List \nDesigened and developed By\\Mohamed Salah ElMorgel\n2025");
    init_ToDoList();
    boolean isExit = false;
    int choice,id;
    final int add=1;
    final int viewAll=2;
    final int viewTask=3;
    final int edit=4;
    final int markDone=5;
    final int markUndone=6;
    final int delete=7;
    final int exit=8;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String description,date,status;

        do
        {
            System.out.print("\n.................................................................\n1- Add new tasks\n" +
                    "2- View all tasks\n" +
                    "3- view specific task\n" +
                    "4- edit task\n" +
                    "5- Mark task as done\n" +
                    "6- Mark task as undone\n" +
                    "7- Delete task\n" +
                    "8- Exit program\n");
            System.out.print("Please choose the option number: ");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice)
            {
                case add:
                    System.out.print("please enter the Description of the task: ");
                    description = scanner.nextLine();
                    System.out.print("please enter the Due Date of the task (dd-mm-yyyy): ");
                    date=scanner.nextLine();
                    add_Task(description, LocalDate.parse(date,formatter),false);
                    save();
                    break;
                case viewAll:
                    view_allTasks();
                    break;
                case viewTask:
                    System.out.println("please enter the id of the task you need: ");
                    id = scanner.nextInt() ;
                    view_Task(id);

                    break;
                case edit:
                    ArrayList<String> edited_task=new ArrayList<>();

                    System.out.println("please enter the id of the task you need: ");
                    id = scanner.nextInt() ;
                    scanner.nextLine();
                    view_Task(id);
                    System.out.print("\nplease enter the Edited Description of the task: ");
                    description = scanner.nextLine();
                    System.out.print("\nplease enter the Edited Due Date of the task (dd-mm-yyyy): ");
                    date=scanner.nextLine();
                    System.out.print("\nplease enter the Edited Status of the task(done or undone): ");
                    status=scanner.next().toLowerCase();
                    if(status.equals("done"))
                        mark_Task_Done(id);
                    else if (status.equals("undone"))
                        mark_Task_UNDone(id);

                    edited_task.add(description);
                    edited_task.add(date);

                    edit_task(id,edited_task);
                    save();

                    break;
                case markDone:
                    System.out.println("please enter the id of the task you need: ");
                    id = scanner.nextInt() ;
                    mark_Task_Done(id);
                    view_Task(id);
                    save();
                    break;
                case markUndone:
                    System.out.println("please enter the id of the task you need: ");
                    id = scanner.nextInt() ;
                    mark_Task_UNDone(id);
                    view_Task(id);
                    save();
                    break;
                case delete:
                    System.out.println("please enter the id of the task you need: ");
                    id = scanner.nextInt() ;
                    System.out.println("This task will be removed");
                    view_Task(id);
                    System.out.println("Confirm deletion (Y/N): ");
                    char x =scanner.next().charAt(0);

                    if (x =='y' || x=='Y')
                        delete_Task(id);

                    save();
                    break;

                case exit:
                    isExit=true;
                    save();
                    break;


                default:
                    System.out.println("please choose valid option");
                    break;
            }

        }while (!isExit);
}


    public static void main(String[] args )
    {

        Start_ToDoList();
//        reset();
//         dummy();
    }



}






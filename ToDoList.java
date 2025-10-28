/*
🧾 3. To-Do List (Mini CLI App)
Goal: Learn how to manage dynamic data and interact with users in loops.
Features:
1- Add new tasks
2- View all tasks
3- Mark tasks as done
4- Delete tasks
5- Exit program

Concepts Practiced:

ArrayList, loops, switch, methods, possibly file writing to save data.*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ToDoList
{
     static int ID = 1;
     static ArrayList<ArrayList<String>> DB = new ArrayList<>();
public static void edit_task(int id, ArrayList<String> edited_task)
{
    DB.get(id).set(1,edited_task.get(0));
    DB.get(id).set(2,edited_task.get(1));
    DB.get(id).set(3,edited_task.get(2));
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
        var task=DB.get(id);
        System.out.print("Task ID: "+task.get(0)+" , ");
        System.out.print("Task Description: "+task.get(1)+ " , ");
        System.out.print("Task Due Date: "+task.get(2)+ " , ");
        System.out.print("Task Status: "+task.get(3)+ " .");
    }
    public static void mark_Task_Done(int id)
    {
         DB.get(id).set(3, String.valueOf(true));

    }
    public static void mark_Task_UNDone(int id)
    {
        DB.get(id).set(3, String.valueOf(false));

    }
public static void delete_Task(){}
public static void save(){}
//public static void exit_Task(){}


    public static void main(String[] args )
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        add_Task("Finish the code of ToDoList", LocalDate.parse("30-10-2025",formatter),false);
        add_Task("Commit the structure of ToDoList", LocalDate.parse("29-10-2025",formatter),true);
        add_Task("Push the structure of ToDoList", LocalDate.parse("28-10-2025",formatter),false);
        add_Task("continue the work with ToDoList", LocalDate.parse("28-10-2025",formatter),false);

        view_allTasks();
        view_Task(2);

        ArrayList<String> edited_task=new ArrayList<>();
        edited_task.add("Edit plan for the task");
        edited_task.add("2025-10-29");
        edited_task.add(String.valueOf(true));
        edit_task(2,edited_task);
        System.out.println();
        view_Task(2);
        System.out.println();
        view_allTasks();
    }



}






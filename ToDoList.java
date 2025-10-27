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
public static void read_Tasks(){}
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
public static void view_Tasks()
{
    for(var task :DB)
    {
        System.out.println(task);
    }


}
public static void mark_Task_Done(){}
public static void delete_Task(){}
public static void save(){}
//public static void exit_Task(){}


    public static void main(String[] args )
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        add_Task("Finish the code of ToDoList", LocalDate.parse("30-10-2025",formatter),false);
        add_Task("Commit the structure of ToDoList", LocalDate.parse("29-10-2025",formatter),false);

        view_Tasks();
    }



}






package JavaProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Project 
{
    public static void main(String[] args) 
    {
       
        ArrayList<Task> tasks = new ArrayList<>();
        TaskManager manager = new TaskManager(tasks);
        managerStart(manager);
        

        
           
        
        // Task task2 = new Task("Java","Learn to code in Java",1);
        // Task task3 = new Task("SQL","Practice SQL Queries",2);
        // ArrayList<Task> tasks = new ArrayList<>();
        // TaskManager manager = new TaskManager(tasks);  
        // manager.AddTasks(task1);
        // manager.AddTasks(task2);
        // manager.AddTasks(task3);
        // manager.markAsComplete(task1);
        // manager.listTasks();
        
        // System.out.println();
        
        // manager.removeTask(task2);
        // manager.listTasks();
        


    }
    public static void managerStart(TaskManager manager)
    {   
        System.out.println(ConsoleColors.CYAN+"\nTask Manager Inc."+ ConsoleColors.GREEN +" \n            -By Soham \n"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED+ConsoleColors.BOLD+"Instructions"+ConsoleColors.RESET+"  :  \n"+ConsoleColors.CYAN+"Press "+ConsoleColors.RED+"1"+ConsoleColors.CYAN+" Add Task "+ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN+"Press "+ConsoleColors.RED+"2"+ConsoleColors.CYAN+" Delete Task "+ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN+"Press "+ConsoleColors.RED+"3"+ConsoleColors.CYAN+" Display All Tasks"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED+"Your Input Below:"+" "+ConsoleColors.RESET);
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();
       
        switch (userInput) {
            case 1:
                System.out.println(ConsoleColors.RED+"Enter Task Title in 1 Word"+ConsoleColors.RESET);
                String userTitle = input.next();
                System.out.println(ConsoleColors.RED+"Enter Task Description in 1 Line"+ConsoleColors.RESET);
                String userDescription = input.nextLine();
                input.nextLine();
                System.out.println(ConsoleColors.RED+"Enter Priority on scale of"+ConsoleColors.CYAN+" 1-10 "+ConsoleColors.RED+"(10 being the highest)"+ConsoleColors.RESET);
                int setPriority = input.nextInt();
                Task task1 = new Task(userTitle,userDescription,setPriority);
                
                manager.AddTasks(task1);
                System.out.println(ConsoleColors.GREEN +"Task Added Successfully"+ConsoleColors.RESET);
                try {
                    Thread.sleep(3000); // 5 seconds timeout
                } catch (InterruptedException e) {
                    System.out.println("Returning to Home Screen!");
                }
                System.out.println();
                clearTerminal();
                managerStart(manager);
                
                break;
        
            case 2:
                
                break;
        
            case 3:
                manager.listTasks();
                break;
        
            default:
                break;
        }
        
    }
    public static void clearTerminal()
    {
        try 
                {
                    if (System.getProperty("os.name").contains("Windows")) 
                    {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } else {
                        new ProcessBuilder("clear").inheritIO().start().waitFor();
                    }
                } catch (IOException | InterruptedException e) 
                {
                    e.printStackTrace();
                }
    }
    
}
class Task
{
    String title;
    String description;
    int priority;
    boolean isComplete;

    Task(String title,String description,int priority)
    {
        this.title = title;
        this.description = description;
        this.priority =  priority;
        this.isComplete = false;
    }
    public void displayTask(Task task)
    {
        String priorityString = "";
        if(task.priority == 1) priorityString = "Urgent";
        else if(task.priority == 2) priorityString = "Moderate";
        else if(task.priority == 3) priorityString = "Chill";
        else priorityString = "Undefined";
        
        String completionString = "";
        if(task.isComplete == true) completionString = "Completed";
        else completionString = "Pending";
        
        System.out.print(ConsoleColors.RED+task.title + " : " + ConsoleColors.CYAN+ task.description + ConsoleColors.RED+" Priority: " );
        System.out.print(priorityString);
        System.out.print(" Status " + completionString);
        System.out.println();
    }
    public void completed(Task task)
    {
        task.isComplete = true;
    }
}
class TaskManager
{
    ArrayList<Task> tasks;

    TaskManager(ArrayList<Task> tasks)
    {
        this.tasks = tasks;
    }

    public void AddTasks(Task task)
    {
        tasks.add(task);
    }
    public void listTasks()
    {
        
        for(Task job : tasks)
        {
           job.displayTask(job);
        }
    }
    public void markAsComplete(Task task)
    {
        task.completed(task);
    }
    public void removeTask(Task task)
    {
        for(int i=0;i<tasks.size();i++)
        {
            if(task.description == tasks.get(i).description && task.title == tasks.get(i).title)
            {
                tasks.remove(i);
                break;
            }
        }
    }

}

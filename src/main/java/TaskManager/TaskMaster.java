package TaskManager;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskMaster {

    public static void remove_task(ArrayList<Task> taskList, int index) {
        taskList.remove(index);
    }

    public static void edit_task(ArrayList<Task> taskList, int index) {
        Scanner input = new Scanner(System.in);
        System.out.println("Edit a Task");
        new_line();
        boolean edit = true;
        while (edit) {
            System.out.println("Title, Description, Progress, Due Date, Swap");
            new_line();
            System.out.println(":");
            String command = input.nextLine();
            new_line();
            switch (command) {
                case "name", "title", "n", "t" -> {
                    System.out.println("Name:");
                    taskList.get(index).title = input.nextLine();
                    edit = false;
                }
                case "desc", "description", "d" -> {
                    System.out.println("Description:");
                    taskList.get(index).description = input.nextLine();
                    edit = false;
                }
                case "swap", "s" -> {
                    System.out.println("Which position:");
                    try {
                        int ind = input.nextInt() - 1;
                        input.nextLine();
                        if (ind >= taskList.size()) {
                            throw new Exception("Not Valid");
                        }
                        Task temp = taskList.get(ind);
                        taskList.set(ind, taskList.get(index));
                        taskList.set(index, temp);
                        edit = false;

                    } catch (Exception e) {
                        System.out.println("Not a valid index");
                    }
                }
                case "prog", "progress", "p" -> {
                    System.out.println("Progress:");
                    taskList.get(index).progress = input.nextLine();
                    edit = false;
                }
                case "date", "due date", "dd" -> {
                    System.out.println("Due Date:");
                    taskList.get(index).due_date = input.nextLine();
                    edit = false;
                }
                case "exit", "quit", "cancel"->{
                    edit = false;
                }
                default ->
                    System.out.println("Not a valid property");
            }
        }
    }

    public static void task_creator(ArrayList<Task> taskList) {
        Scanner input = new Scanner(System.in);
        Task new_task = new Task();
        new_line();
        System.out.println("Create a Task");
        new_line();
        System.out.println("Name: ");
        new_task.title = input.nextLine();
        new_line();
        System.out.println("Decription: ");
        new_task.description = input.nextLine();
        new_line();
        System.out.println("Progress ");
        new_task.progress = input.nextLine();
        new_line();
        System.out.println("Due Date: ");
        new_task.due_date = input.nextLine();
        new_line();
        taskList.add(new_task);
        System.out.println("Task successfully created.");
        new_line();
    }

    public static void new_line() {
        System.out.println("------------------------------------------------------");
    }
}

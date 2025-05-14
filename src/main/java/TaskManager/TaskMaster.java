package TaskManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskMaster {

    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

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
                    boolean date_run = true;
                    while (date_run) {
                        try {
                            System.out.println("Enter in format: MM-DD-YYYY");
                            taskList.get(index).due_date = LocalDate.parse(input.nextLine(), dateFormatter);
                            new_line();
                            date_run = false;
                            edit = false;
                        } catch (Exception e) {
                            System.out.println("Incorrect Date Format");
                            new_line();
                        }
                    }
                }
                case "exit", "quit", "cancel" -> {
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

        boolean date_run = true;
        while (date_run) {
            try {
                System.out.println("Enter in format: MM-DD-YYYY");
                new_task.due_date = LocalDate.parse(input.nextLine(), dateFormatter);
                new_line();
                date_run = false;
            } catch (Exception e) {
                System.out.println("Incorrect Date Format");
                new_line();
            }
        }

        new_line();
        taskList.add(new_task);
        System.out.println("Task successfully created.");
        new_line();
    }

    public static void new_line() {
        System.out.println("------------------------------------------------------");
    }
}

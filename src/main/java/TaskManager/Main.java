package TaskManager;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Task> allTasks = new ArrayList<>();
    static String sav_loc = "TaskList.csv";

    public static void main(String[] args) {
        boolean running = true;
        load(sav_loc);
        Scanner input = new Scanner(System.in);
        new_line();
        new_line();
        while (running) {
            System.out.println("Enter Command: ");
            String command = input.nextLine();
            command = command.toLowerCase();
            String[] com_part = command.split(" ");
            switch (com_part[0]) {
                case "add" -> {
                    TaskMaster.task_creator(allTasks);
                }
                case "remove" -> {
                    try {
                        new_line();
                        TaskMaster.remove_task(allTasks, Integer.parseInt(com_part[1]) - 1);
                        new_line();
                        System.out.println("Succesfully removed Task.");
                        new_line();
                    } catch (Exception e) {
                        System.out.println("Not a valid Index");
                        System.out.println("Format: remove #");
                        new_line();
                    }

                }
                case "view" -> {
                    try {

                        if (com_part[1] != null) {
                            new_line();
                            System.out.println(allTasks.get(Integer.parseInt(com_part[1]) - 1).toString());
                            System.out.println("\n" + allTasks.get(Integer.parseInt(com_part[1]) - 1).description);
                            new_line();
                        }
                    } catch (Exception e) {

                        view_tasks();
                    }
                }
                case "edit" -> {
                    try {
                        new_line();
                        TaskMaster.edit_task(allTasks, Integer.parseInt(com_part[1]) - 1);
                        new_line();
                        System.out.println("Succesfully edited Task.");
                        new_line();
                    } catch (Exception e) {
                        System.out.println("Not a valid Index");
                        System.out.println("Format: edit #");
                        new_line();
                    }
                }
                case "help" -> {
                    new_line();
                    System.out.println("Try the commands:");
                    System.out.println("add, edit, remove, view, quit");
                }

                case "quit" -> {
                    running = false;
                }
                default -> {
                    new_line();
                    System.out.println("Not a valid command.");
                    new_line();
                }
            }
            save(sav_loc);
        }
        save(sav_loc);
    }

    public static void load(String loc) {
        try {
            File list = new File(loc);
            Scanner reader = new Scanner(list);
            while (reader.hasNextLine()) {
                String[] data = (reader.nextLine()).split(",");
                Task new_task = new Task(data[0], data[1], data[2], data[3]);
                allTasks.add(new_task);
            }

        } catch (Exception e) {
            new_line();
            System.out.println("An error occured...");
            System.out.println("Type: Load Error");
            new_line();
        }
    }

    public static void save(String loc) {
        try {
            File save_file = new File(loc);
            try (FileWriter writer = new FileWriter(save_file)) {
                for (Task t : allTasks) {
                    String line = t.title + "," + t.description + "," + t.progress + "," + t.due_date;
                    writer.write(line + "\n");

                }
            }

        } catch (Exception e) {
            new_line();
            System.out.println("An error occured...");
            System.out.println("Type: Save Error");
            new_line();
        }

    }

    public static void new_line() {
        System.out.println("------------------------------------------------------");
    }

    public static void view_tasks() {
        new_line();
        for (int i = 0; i < allTasks.size(); i++) {
            System.out.println((i + 1) + ". " + allTasks.get(i).toString());
        }
        new_line();
    }

}

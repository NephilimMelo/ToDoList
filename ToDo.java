package Carts;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDo {
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String task = scanner.nextLine();
                    addTask(task);
                    break;
                case 2:
                    System.out.print("Enter index of task to mark as completed: ");
                    int index = scanner.nextInt();
                    markTaskAsCompleted(index);
                    break;
                case 3:
                    viewTasks();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        System.out.println("Exiting ToDo List application.");
    }

    private static void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    private static void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            String task = tasks.get(index);
            tasks.remove(index);
            System.out.println("Task marked as completed: " + task);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks added yet.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
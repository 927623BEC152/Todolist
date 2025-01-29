import java.util.ArrayList;
import java.util.Scanner;

// Task class to represent a task
class Task {
    private String title;
    private String dueDate;
    private boolean isCompleted;

    // Constructor
    public Task(String title, String dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        this.isCompleted = false; // Initially, the task is not completed
    }

    // Mark the task as completed
    public void markAsCompleted() {
        isCompleted = true;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        return "Task: " + title + (dueDate != null && !dueDate.isEmpty() ? " | Due: " + dueDate : "") + 
               " | Status: " + (isCompleted ? "Completed" : "Pending");
    }
}

// Main application class
public class ToDoListApp {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. View Pending Tasks");
            System.out.println("4. View Completed Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> markTaskAsCompleted();
                case 3 -> viewPendingTasks();
                case 4 -> viewCompletedTasks();
                case 5 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Method to add a task
    private static void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter due date (optional): ");
        String dueDate = scanner.nextLine();

        tasks.add(new Task(title, dueDate));
        System.out.println("Task added successfully!");
    }

    // Method to mark a task as completed
    private static void markTaskAsCompleted() {
        viewPendingTasks();
        System.out.print("Enter the task number to mark as completed: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (taskNumber > 0 && taskNumber <= tasks.size() && !tasks.get(taskNumber - 1).isCompleted()) {
            tasks.get(taskNumber - 1).markAsCompleted();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid task number or task already completed.");
        }
    }

    // Method to view pending tasks
    private static void viewPendingTasks() {
        System.out.println("\nPending Tasks:");
        int count = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (!tasks.get(i).isCompleted()) {
                System.out.println((i + 1) + ". " + tasks.get(i));
                count++;
            }
        }
        if (count == 0) System.out.println("No pending tasks!");
    }

    // Method to view completed tasks
    private static void viewCompletedTasks() {
        System.out.println("\nCompleted Tasks:");
        int count = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).isCompleted()) {
                System.out.println((i + 1) + ". " + tasks.get(i));
                count++;
            }
        }
        if (count == 0) System.out.println("No completed tasks!");
    }
}

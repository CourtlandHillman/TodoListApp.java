import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoListApp {
    private List<Task> tasks;

    public TodoListApp() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void displayTasks() {
        System.out.println("Your To-Do List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
        }
    }

    public void markTaskAsCompleted(int taskIndex) {
        if (taskIndex >= 1 && taskIndex <= tasks.size()) {
            Task task = tasks.get(taskIndex - 1);
            task.markAsCompleted();
            System.out.println("Task marked as completed: " + task.getDescription());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoListApp todoList = new TodoListApp();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    todoList.addTask(description);
                    System.out.println("Task added!");
                    break;
                case 2:
                    todoList.displayTasks();
                    break;
                case 3:
                    System.out.print("Enter task number to mark as completed: ");
                    int taskIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    todoList.markTaskAsCompleted(taskIndex);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        System.out.println("Exiting To-Do List App. Goodbye!");
        scanner.close();
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListManager {
    private static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter user name: ");
                    String name = scanner.nextLine();
                    users.add(new User(name));
                    break;
                case 2:
                    System.out.print("\nEnter user name: ");
                    name = scanner.nextLine();
                    User user = findUserByName(name);
                    if (user != null) {
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        user.addTask(description);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 3:
                    System.out.print("\nEnter user name: ");
                    name = scanner.nextLine();
                    user = findUserByName(name);
                    if (user != null) {
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        user.markTaskAsCompleted(description);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 4:
                    System.out.print("\nEnter user name: ");
                    name = scanner.nextLine();
                    user = findUserByName(name);
                    if (user != null) {
                        user.printTasks();
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static User findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}
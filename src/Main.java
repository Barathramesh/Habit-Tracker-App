import Controller.UserController;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        UserController userController = new UserController(scan);
        userController.initialize();

        System.out.println();
        System.out.println("Welcome to Habit Tracker Application");

        while(true) {
            System.out.println();
            System.out.println("1. Login into the System.");
            System.out.println("2. Sign up into the System.");
            System.out.println("3. Logout.");
            int choice = Integer.parseInt(scan.nextLine().trim());

            switch(choice) {
                case 1:
                    userController.login();
                    break;
                case 2:
                    userController.signup();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
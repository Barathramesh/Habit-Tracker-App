package Controller;

import Model.User;
import Service.CommunityService;
import Service.HabitService;
import Service.UserService;

import java.util.*;

public class UserController {
    private final Scanner scan;
    private final UserService userService = new UserService();
    private final CommunityController communityController;
    private final HabitController habitController;
    private final JournalController journalController;
    private final PostController postController;
    private final ProgressController progressController;
    private final RemainderController remainderController;

    public UserController(Scanner scan) {
        this.scan = scan;
        CommunityService communityService = new CommunityService();
        HabitService habitService = new HabitService();
        this.communityController = new CommunityController(scan, communityService);
        this.habitController = new HabitController(scan, habitService);
        this.journalController = new JournalController(scan);
        this.postController = new PostController(scan, communityService);
        this.progressController = new ProgressController(scan, habitService);
        this.remainderController = new RemainderController(scan);
    }

    public void initialize() {
        userService.register("barath","123","123456789");
        userService.register("ajay","123","123456789");
    }

    public void signup() {
        while(true) {
            System.out.println("Enter your username:");
            String username = scan.nextLine();
            if(userService.existOrNot(username)) {
                System.out.println("Username already exists!");
                System.out.println();
                continue;
            }
            System.out.println("Enter your password:");
            String password = scan.nextLine();
            System.out.println("Enter your mobile number:");
            String mobileNumber = scan.nextLine();

            userService.register(username, password, mobileNumber);
            System.out.println("You have successfully registered!. Now Login into the System.");
            break;
        }
    }

    public void login() {
        while (true) {
            System.out.println("Enter your username:");
            String username = scan.nextLine().trim();
            System.out.println("Enter your password:");
            String password = scan.nextLine().trim();
            User user = userService.login(username, password);
            if(user != null) {
                System.out.println("You have successfully logged into the System.");
                showMenu(user);
                break;
            } else {
                System.out.println("Invalid username or password.");
                System.out.println("Try again? (y/n)");
                String retry = scan.nextLine().trim();
                if(!retry.equalsIgnoreCase("y")) {
                    System.out.println("Returning to main menu.");
                    return;
                }
            }

        }
    }

    public void showMenu(User user) {
        while(true) {
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. View Habits Menu:");
            System.out.println("2. View Community Menu:");
            System.out.println("3. View Journal Menu:");
            System.out.println("4. View Post Menu:");
            System.out.println("5. Create a Remainder:");
            System.out.println("6. View Progress:");
            System.out.println("7. Return to Login Page:");

            int choice = Integer.parseInt(scan.nextLine());

            switch(choice) {
                case 1:
                    habitController.HabitMenu(user);
                    break;
                case 2:
                    communityController.CommunityMenu(user);
                   break;
                case 3:
                    journalController.JournalMenu(user);
                   break;
                case 4:
                    postController.PostMenu(user);
                   break;
                case 5:
                    remainderController.createRemainder(user);
                    break;
                case 6:
                    progressController.ProgressMenu(user);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

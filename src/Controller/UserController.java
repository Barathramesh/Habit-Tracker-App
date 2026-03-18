package Controller;

import Model.User;
import Service.CommunityService;
import Service.UserService;

import java.util.Scanner;

public class UserController {
    private final Scanner scan;
    private final UserService userService = new UserService();
    private final CommunityController communityController;
    private final HabitController habitController;
    private final JournalController journalController;
    private final PostController postController;

    public UserController(Scanner scan) {
        this.scan = scan;
        CommunityService communityService = new CommunityService();
        this.communityController = new CommunityController(scan, communityService);
        this.habitController = new HabitController(scan);
        this.journalController = new JournalController(scan);
        this.postController = new PostController(scan, communityService);
    }
    public void initialize() {
        userService.register("barath","123","123456789");
        userService.register("ajay","123","123456789");
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

    public void showMenu(User user) {
        while(true) {
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. View Habits Menu:");
            System.out.println("2. View Community Menu:");
            System.out.println("3. Write a Journal:");
            System.out.println("4. View All Journals:");
            System.out.println("5. Create a Post:");
            System.out.println("6. Return to Login Page:");

            int choice = Integer.parseInt(scan.nextLine());

            switch(choice) {
                case 1:
                    habitController.HabitMenu(user);
                    break;
                case 2:
                    communityController.CommunityMenu(user);
                   break;
                case 3:
                    journalController.createJournal(user);
                   break;
                case 4:
                    journalController.viewAllMyJournal(user);
                    break;
                case 5:
                    postController.createPost(user);
                   break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

}

package Controller;

import Model.Habit;
import Model.User;
import Service.HabitService;
import Service.ProgressService;

import java.util.List;
import java.util.Scanner;

public class ProgressController {
    private Scanner scan;
    private HabitService habitService;
    private ProgressService progressService = new ProgressService();

    public ProgressController(Scanner scan, HabitService habitService) {
        this.scan = scan;
        this.habitService = habitService;
    }


    public void ProgressMenu(User user) {
        while (true) {
            System.out.println("1. Overall Progress:");
            System.out.println("2. Back to Main Menu.");

            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    overAllProgress(user);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    private void overAllProgress(User user) {
        List<Habit> habits = habitService.getMyHabits(user);
        progressService.showOverallProgress(user, habits);
    }
}

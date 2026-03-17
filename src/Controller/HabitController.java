package Controller;

import Model.Habit;
import Model.PredefinedHabit;
import Model.Reward;
import Model.User;
import Service.HabitService;
import Service.RewardService;

import java.util.*;

public class HabitController {
    private final Scanner scan;
    private final HabitService habitService;
    private final RewardService rewardService = new RewardService();
    private int habitID = 5;
    private int rewardID = 1;

    public HabitController(Scanner scan, HabitService habitService) {
        this.scan = scan;
        this.habitService = habitService;
    }

    public void HabitMenu(User user) {
        while (true) {
            System.out.println();
            System.out.println("1. View Default Habits:");
            System.out.println("2. Customize your Habits:");
            System.out.println("3. View All My Habits:");
            System.out.println("4. Completed a Habit:");
            System.out.println("5. Back to Main Menu.");

            int choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1:
                    defaultHabits(user);
                    break;
                case 2:
                    customHabits(user);
                    break;
                case 3:
                    viewMyHabits(user);
                    break;
                case 4:
                    completedMyHabit(user);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    private void defaultHabits(User user) {
        System.out.println("Default Habits are listed below:");
        HashMap<Integer, String> defaultHabit = PredefinedHabit.getHabits();

        for(int habit : defaultHabit.keySet()) {
            System.out.println(habit+". "+defaultHabit.get(habit));
        }

        System.out.println("Choose an ID:");
        int choice = Integer.parseInt(scan.nextLine());
        System.out.println("Tell me whether you can do it on(Daily/Weekly/Monthly):");
        String choice2 = scan.nextLine();

        String habit = defaultHabit.get(choice);
        habitService.predefinedHabits(choice, habit, user, choice2);
        System.out.println("You have successfully started the Habit.");
    }

    private void customHabits(User user) {
        System.out.println("Please Enter a Habit:");
        String habit = scan.nextLine();
        System.out.println("Tell me whether you can do it on(Daily/Weekly/Monthly):");
        String choice = scan.nextLine();

        habitService.customHabits(habitID++, habit, user, choice);
        System.out.println("You have successfully started the Habit.");
    }

    private void viewMyHabits(User user) {
        System.out.println("List of All your Habits:");
        List<Habit> myhabits = habitService.getMyHabits(user);
        if(myhabits.isEmpty()) {
            System.out.println("No habits found");
        }else {
            for (Habit habit : myhabits) {
                System.out.println(habit);
            }
        }
    }

    private void completedMyHabit(User user) {
        System.out.println("Have completed any of your following Habits:");
        List<Habit> myhabits = habitService.getMyHabits(user);
        if(!myhabits.isEmpty()) {
            for (Habit habit : myhabits) {
                System.out.println(habit);
            }
            System.out.println("Enter a Habit you have completed:");
            String habit = scan.nextLine();
            habitService.completedMyHabit(habit, user);
            System.out.println("Keep rocking..");

            //Reward Creation
            Reward myreward = rewardService.generateReward(user, habit, rewardID++);
            System.out.println(myreward);
        } else {
            System.out.println("No habits found");
        }
    }
}

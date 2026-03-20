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
    private final HabitService habitService = new HabitService();
    private final RewardService rewardService;
    private final RemainderController remainderController;
    private int habitID = 5;

    public HabitController(Scanner scan, RewardService rewardService) {
        this.scan = scan;
        this.remainderController = new RemainderController(scan);
        this.rewardService = rewardService;
    }

    public void HabitMenu(User user) {
        while (true) {
            System.out.println();
            System.out.println("1. View Default Habits:");
            System.out.println("2. Customize your Habits:");
            System.out.println("3. View All My Habits:");
            System.out.println("4. Completed a Habit:");
            System.out.println("5. View My Rewards:");
            System.out.println("6. Create a Remainder:");
            System.out.println("7. Back to Main Menu.");

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
                    viewMyRewards(user);
                    break;
                case 6:
                    createRemainder(user);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    private void createRemainder(User user) {
        while (true) {
            System.out.println("Enter Habit Name:");
            String habitName = scan.nextLine();
            Habit habit = habitService.existsOrNot(user, habitName);
            if (habit != null) {
                remainderController.createRemainder(user, habit);
                break;
            } else {
                System.out.println("Invalid Habit Name!");
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
        if (habitService.existsOrNot(user, habit) != null) {
            System.out.println("Habit already exists!");
            return;
        }
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
        List<Habit> myhabits = habitService.getMyHabits(user);

        if(myhabits.isEmpty()) {
            System.out.println("No habits found");
            return;
        }

        myhabits.forEach(System.out::println);
        String habitName;

        while(true) {
            System.out.println("Enter a Habit you have completed:");
            habitName = scan.nextLine();

            Habit habit = habitService.getSingleHabit(habitName, user);
            if(habit == null) {
                System.out.println("Invalid Habit Name!");
            } else {
                break;
            }
        }

        Habit completedHabit = habitService.markHabitCompleted(user, habitName);

        if(completedHabit == null) {
            return;
        }

        List<Reward> rewards = rewardService.processRewards(user, completedHabit);
        rewards.forEach(System.out::println);

        System.out.println("Keep rocking.. 🚀");
    }


    private void viewMyRewards(User user) {
        List<Reward> myRewards = rewardService.getRewardsByUser(user);
        if(!myRewards.isEmpty()) {
            for (Reward reward : myRewards) {
                System.out.println(reward);
            }
        }else {
            System.out.println("No rewards found");
        }
    }
}

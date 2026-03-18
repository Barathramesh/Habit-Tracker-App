package Service;

import Model.Habit;
import Model.User;

import java.time.LocalDate;
import java.util.*;

public class HabitService {
    private final List<Habit> habits = new ArrayList<>();

    public void predefinedHabits(int habitID, String habit, User user, String frequency) {
        Habit habit1 = new Habit(user.getUsername(), habitID, habit, frequency);
        habits.add(habit1);
    }

    public void customHabits(int habitID, String habit, User user, String frequency) {
        Habit habit1 = new Habit(user.getUsername(), habitID, habit, frequency);
        habits.add(habit1);
    }

    public List<Habit> getMyHabits(User user) {
        List<Habit> myhabits = new ArrayList<>();
        for(Habit habit : habits) {
            if(habit.getUserName().equals(user.getUsername())) {
               myhabits.add(habit);
            }
        }
        return myhabits;
    }

    public Habit markHabitCompleted(User user, String habitName) {
        List<Habit> habits = getMyHabits(user);
        for (Habit habit : habits) {
            if (habit.getHabitName().equalsIgnoreCase(habitName)) {
                LocalDate today = LocalDate.now();
                if (today.equals(habit.getLastcompletedDate())) {
                    System.out.println("Already completed today!");
                    return habit;
                }

                if (habit.getLastcompletedDate() != null && habit.getLastcompletedDate().plusDays(1).equals(today)) {
                    habit.setStreak(habit.getStreak() + 1);
                } else {
                    habit.setStreak(1); // reset streak
                }

                habit.setLastcompletedDate(today);
                user.setTotalHabitsCompleted(user.getTotalHabitsCompleted() + 1);
                return habit;
            }
        }
        return null;
    }

}

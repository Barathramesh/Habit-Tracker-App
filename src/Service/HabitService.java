package Service;

import Model.Habit;
import Model.User;

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

    public void completedMyHabit(String habit, User user) {
        for(Habit habit1 : habits) {
            if(habit1.getUserName().equals(user.getUsername()) && habit1.getHabitName().equals(habit)) {
                 habit1.setCompletionStatus(true);
                 int points = user.getPoints();
                 String frequency = habit1.getFrequency();
                 if(frequency.equals("Daily")) {
                     points += 15;
                 } else if(frequency.equals("Weekly")) {
                     points += 10;
                 } else {
                     points += 5;
                 }
                 user.setPoints(points);
            }
        }
    }
}

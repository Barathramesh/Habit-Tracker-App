package Service;

import Model.Habit;
import Model.User;

import java.time.LocalDate;
import java.util.*;

public class HabitService {

    public void predefinedHabits(int habitID, String habit, User user, String frequency) {
        Habit habit1 = new Habit(user.getUsername(), habitID, habit, frequency);
        user.addHabit(habit1);
    }

    public void customHabits(int habitID, String habit, User user, String frequency) {
        Habit habit1 = new Habit(user.getUsername(), habitID, habit, frequency);
        user.addHabit(habit1);
    }

    public List<Habit> getMyHabits(User user) {
        return user.getHabits();
    }

    public Habit getSingleHabit(String habitname, User user) {
        for(Habit habit : user.getHabits()) {
            if(habit.getHabitName().equals(habitname)) {
                return habit;
            }
        }
        return null;
    }

    public Habit markHabitCompleted(User user, String habitName) {
        Habit myhabit = getSingleHabit(habitName, user);

        if (myhabit == null) {
            return null;
        }
        LocalDate today = LocalDate.now();

        if (today.equals(myhabit.getLastcompletedDate())) {
            System.out.println("Habit already completed today!");
            return null;
        }

        if (myhabit.getLastcompletedDate() == null) {
            myhabit.setStreak(1);
        } else if (myhabit.getLastcompletedDate().plusDays(1).equals(today)) {
            myhabit.setStreak(myhabit.getStreak() + 1);
        } else {
            myhabit.setStreak(1);
        }

        myhabit.setLastcompletedDate(today);
        user.setTotalHabitsCompleted(user.getTotalHabitsCompleted() + 1);

        return myhabit;
    }

    public Habit existsOrNot(User user, String habitName) {
        for(Habit habit : user.getHabits()) {
            if(habit.getHabitName().equals(habitName)) {
                return habit;
            }
        }
        return null;
    }
}

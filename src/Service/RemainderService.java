package Service;

import Model.Habit;
import Model.Remainder;
import Model.User;

import java.time.*;
import java.util.*;
import java.util.concurrent.*;

public class RemainderService {

    public void createRemainder(int remainderID, User user, Habit habit, LocalDateTime reminderTime) {
        Remainder remainder = new Remainder(remainderID, user.getUsername(), habit.getHabitName(), reminderTime);
        habit.addReminders(remainder);
    }

    public void scheduleReminder(User user, Habit habit, Remainder r) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        LocalDateTime now = LocalDateTime.now();
        long delay = Duration.between(now, r.getRemainderTime()).toMillis();

        if (delay < 0) {
            System.out.println("Cannot schedule past reminder");
            return;
        }

        scheduler.schedule(() -> {
            System.out.println("🔔 Reminder for " + user.getUsername()
                    + ": Time to do habit -> " + habit.getHabitName());

            r.markTriggered();
            scheduler.shutdown();

        }, delay, TimeUnit.MILLISECONDS);
    }


    public void startReminderChecker(User user) {
        for (Habit habit : user.getHabits()) {
            for (Remainder r : habit.getReminders()) {
                scheduleReminder(user, habit, r);
            }
        }
    }
}

package Service;

import Model.Remainder;
import Model.User;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RemainderService {
    List<Remainder> remainderList = new ArrayList<>();

    public void create(int remainderID, User user, String habitName, LocalDateTime reminderTime) {
        Remainder remainder = new Remainder(remainderID, user.getUsername(), habitName, reminderTime);
        remainderList.add(remainder);
    }
    public void startReminderChecker() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0);

            for (Remainder r : remainderList) {
                LocalDateTime reminderTime = r.getRemainderTime().withSecond(0).withNano(0);

                if (!r.isTriggered() && !now.isBefore(reminderTime)) {
                    System.out.println("🔔 Reminder for " + r.getUsername() +
                            ": Time to do habit -> " + r.getHabitname());

                    r.markTriggered();
                }
            }
        }, 0, 1, TimeUnit.MINUTES);
    }
}

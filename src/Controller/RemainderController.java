package Controller;

import Model.Habit;
import Model.User;
import Service.RemainderService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class RemainderController {
    private final Scanner scan;
    private final RemainderService remainderService = new RemainderService();
    private int remainderID = 1;

    public RemainderController(Scanner scan) {
        this.scan = scan;
    }

    public void createRemainder(User user, Habit habit) {
        System.out.print("Enter date (yyyy-MM-dd): ");
        String dateInput = scan.nextLine();

        System.out.print("Enter time (HH:mm) in 24-Hour format: ");
        String timeInput = scan.nextLine();

        LocalDate date = LocalDate.parse(dateInput);
        LocalTime time = LocalTime.parse(timeInput);
        LocalDateTime reminderDateTime = LocalDateTime.of(date, time);

        remainderService.createRemainder(remainderID++, user, habit, reminderDateTime);
        System.out.println("✅ Reminder scheduled successfully!");

        remainderService.startReminderChecker(user);
    }
}

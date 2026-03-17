package Controller;

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

    public void createRemainder(User user) {
        System.out.println("Enter Habit Name:");
        String habitName = scan.nextLine();
        System.out.print("Enter date (yyyy-MM-dd): ");
        String dateInput = scan.nextLine();

        System.out.print("Enter time (HH:mm): ");
        String timeInput = scan.nextLine();

        LocalDate date = LocalDate.parse(dateInput);
        LocalTime time = LocalTime.parse(timeInput);
        LocalDateTime reminderDateTime = LocalDateTime.of(date, time);

        remainderService.create(remainderID++, user, habitName, reminderDateTime);
        System.out.println("Remainder has been created successfully!");
        remainderService.startReminderChecker();
    }
}

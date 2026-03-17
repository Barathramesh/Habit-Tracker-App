package Controller;

import Model.User;
import Service.RemainderService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        System.out.println("Enter reminder time (yyyy-MM-dd HH:mm):");
        String timeInput = scan.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime reminderTime = LocalDateTime.parse(timeInput, formatter);

        remainderService.create(remainderID++, user, habitName, reminderTime);
        System.out.println("Remainder has been created successfully!");
    }
}

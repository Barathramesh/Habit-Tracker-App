package Controller;

import Model.Journal;
import Model.User;
import Service.JournalService;

import java.util.*;

public class JournalController {
    private final Scanner scan;
    private final JournalService journalService =  new JournalService();
    private int jounarlId = 1;

    public JournalController(Scanner scan) {
        this.scan = scan;
    }

    public void createJournal(User user) {
        System.out.println("Enter your current mood (Happy, Sad, ...):");
        String mood = scan.nextLine();
        System.out.println("Enter your content (type END to finish):");
        StringBuilder sb = new StringBuilder();

        while(true) {
            String line = scan.nextLine();
            if(line.equalsIgnoreCase("END")) {
                break;
            }
            sb.append(line).append(". ");
        }

        String content = sb.toString();
        Journal journal = journalService.create(jounarlId, mood, content, user);
        System.out.println("Journal Created Successfully");
        System.out.println(journal);
    }

    public void viewAllMyJournal(User user) {
        List<Journal> listofJournal = journalService.getAllJournal(user);
        if(listofJournal.isEmpty()) {
            System.out.println("No journal found");
        }else {
            System.out.println("Journal List:");
            for (Journal journal : listofJournal) {
                System.out.println(journal);
            }
        }
    }
}

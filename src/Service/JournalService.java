package Service;

import Model.Journal;
import Model.User;

import java.util.*;

public class JournalService {
    private final Map<String, Integer> userJournalCount = new HashMap<>();

    public Journal create(String mood, String content, User user) {
        int id = userJournalCount.getOrDefault(user.getUsername(),0) + 1;
        userJournalCount.put(user.getUsername(), id);

        Journal journal = new Journal(id, user.getUsername(), content, mood);
        user.setJournals(journal);
        return journal;
    }

    public List<Journal> getAllJournal(User user) {
        return new ArrayList<>(user.getJournals());
    }
}

package Service;

import Model.Journal;
import Model.User;

import java.util.*;

public class JournalService {
    public Journal create(int journalId, String mood, String content, User user) {
        Journal journal = new Journal(journalId, user.getUsername(), content, mood);
        user.setJournals(journal);
        return journal;
    }

    public List<Journal> getAllJournal(User user) {
        return new ArrayList<>(user.getJournals());
    }
}

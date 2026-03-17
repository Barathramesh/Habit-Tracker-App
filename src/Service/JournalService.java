package Service;

import Model.Journal;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class JournalService {
    List<Journal> listofJournal =  new ArrayList<Journal>();

    public Journal create(int journalId, String mood, String content, User user) {
        Journal journal = new Journal(journalId, user.getUsername(), mood, content);
        listofJournal.add(journal);
        return journal;
    }

    public List<Journal> getAllJournal(User user) {
        List<Journal> list = new ArrayList<>();
        for(Journal journal : listofJournal) {
            if(user.getUsername().equals(journal.getUserId())) {
                list.add(journal);
            }
        }
        return list;
    }
}

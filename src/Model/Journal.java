package Model;

import java.time.LocalDate;

public class Journal {
    private final int journalId;
    private String userId;
    private final String content;
    private final String mood;
    private final LocalDate date;


    public Journal(int journalId, String userId, String content, String mood) {
        this.journalId = journalId;
        this.userId = userId;
        this.content = content;
        this.mood = mood;
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        return "{" +
                "Journal Id = " + journalId +
                ",Content = " + content + '\'' +
                ",Mood = " + mood + '\'' +
                ",Date = " + date +
                '}';
    }
}

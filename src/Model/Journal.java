package Model;

import java.time.LocalDate;

public class Journal {
    private int journalId;
    private String userId;
    private String content;
    private String mood;
    private LocalDate date;


    public Journal(int journalId, String userId, String content, String mood) {
        this.journalId = journalId;
        this.userId = userId;
        this.content = content;
        this.mood = mood;
        this.date = LocalDate.now();
    }

    public int getJournalId() {
        return journalId;
    }

    public void setJournalId(int journalId) {
        this.journalId = journalId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

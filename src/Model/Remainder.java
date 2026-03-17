package Model;

import java.time.LocalDateTime;

public class Remainder {
    private int RemainderID;
    private String username;
    private String Habitname;
    private LocalDateTime remainderTime;
    private boolean status;

    public Remainder(int remainderID, String username, String habitname, LocalDateTime remainderTime) {
        RemainderID = remainderID;
        this.username = username;
        Habitname = habitname;
        this.remainderTime = remainderTime;
        this.status = false;
    }

    public int getRemainderID() {
        return RemainderID;
    }

    public void setRemainderID(int remainderID) {
        RemainderID = remainderID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHabitname() {
        return Habitname;
    }

    public void setHabitname(String habitname) {
        Habitname = habitname;
    }

    public LocalDateTime getRemainderTime() {
        return remainderTime;
    }

    public void setRemainderTime(LocalDateTime remainderTime) {
        this.remainderTime = remainderTime;
    }

    public boolean isTriggered() {
        return status;
    }
    public void markTriggered() {
        this.status = true;
    }
}

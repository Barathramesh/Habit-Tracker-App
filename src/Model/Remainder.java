package Model;

import java.time.LocalDateTime;

public class Remainder {
    private int RemainderID;
    private final String username;
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

    public String getUsername() {
        return username;
    }

    public LocalDateTime getRemainderTime() {
        return remainderTime;
    }

    public void markTriggered() {
        this.status = true;
    }
}

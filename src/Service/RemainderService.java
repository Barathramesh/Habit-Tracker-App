package Service;

import Model.Remainder;
import Model.User;

import java.time.LocalDateTime;
import java.util.*;

public class RemainderService {
    List<Remainder> remainderList = new ArrayList<>();

    public void create(int remainderID, User user, String habitName, LocalDateTime reminderTime) {
        Remainder remainder = new Remainder(remainderID, user.getUsername(), habitName, reminderTime);
        remainderList.add(remainder);
    }



}

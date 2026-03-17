package Model;

import java.util.*;

public class PredefinedHabit {
    public static final HashMap<Integer, String> predefinedHabits = new HashMap<>();

    static {
        predefinedHabits.put(1,"Exercise");  predefinedHabits.put(2,"Drink Water");
        predefinedHabits.put(3,"Meditation");  predefinedHabits.put(4,"Reading");
    }

    public static HashMap<Integer, String> getHabits() {
        return predefinedHabits;
       }
}

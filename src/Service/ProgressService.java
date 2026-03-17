package Service;

import Model.Habit;
import Model.User;

import java.util.List;

public class ProgressService {

    public void showOverallProgress(User user, List<Habit> habits) {
        int total = habits.size();
        int completed = 0;

        for (Habit h : habits) {
            if (h.isCompletionStatus()) completed++;
        }
        double rate = total == 0 ? 0 : (completed * 100.0 / total);

        System.out.println("----- Overall Progress -----");
        System.out.println("Total Habits    : " + total);
        System.out.println("Completed       : " + completed);
        System.out.printf( "Completion Rate : %.1f%%%n", rate);
        System.out.println("Total Points    : " + user.getPoints());
    }

    public void showHabitProgress(List<Habit> habits2, String habitName) {

    }
}

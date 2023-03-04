package Tasks;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class WeeklyTasks extends Tasks {
    public boolean appearsInData(LocalDate date) {
        long weekly = ChronoUnit.DAYS.between(getDateTime().toLocalDate(), date);
        return (weekly >= 0 && weekly % 7 == 0);
    }
}

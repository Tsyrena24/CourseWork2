package Tasks;

import java.time.LocalDate;

public class DailyTasks extends Tasks {
    public boolean appearsInData(LocalDate date) {
        return date.equals(getDateTime().toLocalDate()) || date.isAfter(getDateTime().toLocalDate());
    }
}
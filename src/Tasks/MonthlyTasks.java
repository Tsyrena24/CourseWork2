package Tasks;

import java.time.LocalDate;
import java.time.Period;

public class MonthlyTasks extends Tasks {
    public boolean appearsInData(LocalDate date) {
        Period periodData = Period.between(getDateTime().toLocalDate(), date);
        return (periodData.getYears() >= 0 && periodData.getMonths() >= 0 && periodData.getDays() == 0);
    }
}
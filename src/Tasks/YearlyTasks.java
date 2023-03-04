package Tasks;

import java.time.LocalDate;
import java.time.Period;

public class YearlyTasks extends Tasks {

    public boolean appearsInData(LocalDate date) {
        Period yaerPeriod = Period.between(getDateTime().toLocalDate(), date);
        return yaerPeriod.getYears() >= 0 && yaerPeriod.getMonths() == 0 && yaerPeriod.getDays() == 0;
    }

}

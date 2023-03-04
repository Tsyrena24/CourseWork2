package Tasks;

import java.time.LocalDate;
import java.util.Objects;
        public class OneTimeTasks extends Tasks {
            public boolean appearsInData(LocalDate date) {
                return Objects.equals(getDateTime().toLocalDate(), date);
            }

}

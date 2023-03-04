package Enums;

import Tasks.Tasks;
import Tasks.DailyTasks;
import Tasks.OneTimeTasks;
import Tasks.WeeklyTasks;
import Tasks.YearlyTasks;
import Tasks.MonthlyTasks;

public enum TaskSelection {
    ONETIME {
        @Override
        public Tasks addTask() {
            return new OneTimeTasks();
        }
    },
    DAILY {
        @Override
        public Tasks addTask() {
            return new DailyTasks();
        }
    },
    WEEKLY {
        @Override
        public Tasks addTask() {
            return new WeeklyTasks();
        }
    },
    MONTHLY  {
        @Override
        public Tasks addTask() {
            return new MonthlyTasks();
        }
    },
    YEARLY {
        @Override
        public Tasks addTask() {
            return new YearlyTasks();
        }
    };

    public abstract Tasks addTask();
}

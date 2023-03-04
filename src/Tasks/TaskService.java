package Tasks;

import Enums.TaskSelection;
import Exceptions.ArgumentException;
import Exceptions.TaskNotFoundException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<Integer, Tasks> taskMap = new HashMap<>();

    public void add(TaskSelection taskSlection) throws ArgumentException {
        var data = taskSlection.addTask();
        data.askData();
        taskMap.putIfAbsent(data.getId(), data);
        System.out.println("Задача успешно создана: " + data);
    }
    public void remove(int id) throws TaskNotFoundException {
        Tasks task = taskMap.get(id);
        taskMap.values().removeIf(t -> t.getId() == id);
        System.out.printf("Задача %s' была успешно удаленна \n", task);
        if (task == null) {
            throw new TaskNotFoundException("Извините, отсутствует задача с таким ID");
        }
    }
    public void getAllByDate(LocalDate localDate) throws TaskNotFoundException {
        for (Map.Entry<Integer, Tasks> taskMap : taskMap.entrySet()) {
            LocalDate taskDate = taskMap.getValue().getDateTime().toLocalDate();
            if (((LocalDate) taskDate).equals(localDate)) {
                System.out.println(taskMap.getKey() + " " + taskMap.getValue());
            }
            else if (localDate.isAfter(taskDate) && taskMap.getValue().appearsInData(localDate)) {
                System.out.println(taskMap.getKey() + " " + taskMap.getValue());
            } else throw new TaskNotFoundException("На эту дату нет задач.");
        }
    }

    public void listTaskMap() {
        System.out.println("Список задач: ");
        for (Map.Entry<Integer, Tasks> taskMap : taskMap.entrySet()) {
            System.out.println(taskMap.getKey() + " " + taskMap.getValue());
        }
    }

}

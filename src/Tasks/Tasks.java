package Tasks;

import Enums.TypeTask;
import Exceptions.ArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Tasks {
    private String name;
    private TypeTask type;
    private LocalDateTime dateTime;
    private String description;
    private static int generatorID = 0;
    private final int id;

    public Tasks() {
        generatorID++;
        id = generatorID;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public TypeTask getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tasks task = (Tasks) o;
        return id == task.id && Objects.equals(name, task.name) && type == task.type && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, id, dateTime, description);
    }

    @Override
    public String toString() {
        return String.format("id: %d, тип: %s, название: %s, описание: %s, дата и время: %s", id, type, name,
                description, InputData.dateTimeToString(dateTime));
    }

    public void askData() throws ArgumentException {
        System.out.println("Выберите тип задачи:");
        for (TypeTask taskType : TypeTask.values()) {
            System.out.println(taskType);
        }
        type = TypeTask.valueOf(InputData.askString("Вы выбрали").toUpperCase());
        name = InputData.askString("Введите название задачи");
        if (name == null || name.isBlank() || name.isEmpty()) {
            throw new ArgumentException("Извините чтото пошло не так. Пожалуйста, попробуйте еще раз вести название");
        }
        description = InputData.askString("Введите описание задачи");
        if (description == null || description.isBlank() || description.isEmpty()) {
            throw new ArgumentException("Извините чтото пошло не так. Пожалуйста, попробуйте еще раз вести описание" );
        }
        dateTime = InputData.askDateTime("Введите дату и время");
    }

    public abstract boolean appearsInData(LocalDate localDate);

}


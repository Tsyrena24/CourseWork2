import Enums.TaskSelection;
import Exceptions.ArgumentException;
import Exceptions.TaskNotFoundException;
import Tasks.InputData;
import Tasks.TaskService;

import java.util.Scanner;

public class Main {
    private static final TaskService taskService = new TaskService();

    public static void main(String[] args) {

        try (Scanner list = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.println("Пожалуйста выберете команду: ");
                if (list.hasNextInt()) {
                    int menu = list.nextInt();
                    switch (menu) {
                        case 1:
                            add();
                            break;
                        case 2:
                            remove();
                            break;
                        case 3:
                            getAllByDate();
                            break;
                        case 4:
                            listTaskMap();
                            break;
                        case 0:
                            break label;
                        default:
                            System.out.println("Извините, неизвестный пункт меню, повторите попытку");
                    }
                } else {
                    list.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
            System.out.println("Спасибо, тем что воспользовались ежедневником! Хорошего дня!");
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ArgumentException e) {
            System.out.println(e.getArgument());
        }
    }

    private static void printMenu() {
        System.out.println("Команды: ");
        System.out.println("1. Добавить задачу");
        System.out.println("2. Удалить задачу ");
        System.out.println("3. Получить задание на указанную дату");
        System.out.println("4. Показать список задач");
        System.out.println("0. Выход");
    }

    private static void add() throws ArgumentException {
        System.out.println("Пожалуйста, выберите вид задачи: ");
        for (TaskSelection taskSelection : TaskSelection.values()) {
            System.out.println(taskSelection);
        }
        var strPeriodicity = InputData.askString("Вы выбрали").toUpperCase();
        var periodicity = TaskSelection.valueOf(strPeriodicity);
        taskService.add(periodicity);
    }

    private static void remove() throws TaskNotFoundException {
        int id = InputData.askInt("Введите ID, чтобы удалить задачу");
        taskService.remove(id);
    }

    private static void getAllByDate() throws TaskNotFoundException {
        var date = InputData.askDate("Пожалуйста, введите дату, чтобы внести задачу ");
        taskService.getAllByDate(date);
    }

    private static void listTaskMap() {
        taskService.listTaskMap();
    }
}

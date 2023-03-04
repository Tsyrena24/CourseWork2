import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LiveCodingName {
    public static void main(String[] args) {
        java.util.List<String> names = new ArrayList<>();
        List<String> names1 = new ArrayList<>();
        String names2;

        names.add("Петя");
        names.add("Сережа");
        names.add("Миша");
        names.add("Таня");
        names.add("Катя");
        names.add("Вова");
        names.add("Илья");
        System.out.println("Имена: "+names);

        for (String name : names) {
            names2 = name.substring(1);
            names1.add(names2);
        }

        System.out.println("Имена без первой буквы: "+names1);

    }
}


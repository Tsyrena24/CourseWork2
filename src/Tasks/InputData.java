package Tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputData {
    public static final String DATE_FORMAT = "dd.MM.yyyy";
    public static final String DATE_TIME_FORMAT = "dd.MM.yyyy HH:mm";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    private static final Scanner scannerData = new Scanner(System.in).useDelimiter("\\n");

    public static LocalDate askDate(String message) {
        System.out.print(message + " (" + DATE_FORMAT + "): ");
        var inDate = scannerData.next();
        return LocalDate.parse(inDate, DATE_FORMATTER);
    }

    public static LocalDateTime askDateTime(String message) {
        System.out.println(message + " (" + DATE_TIME_FORMAT + "): ");
        var inDateTime = scannerData.next();
        return LocalDateTime.parse(inDateTime, DATE_TIME_FORMATTER);
    }

    public static String askString(String message) {
        System.out.print(message + ": ");
        return scannerData.next();
    }

    public static int askInt(String message) {
        System.out.println(message + ": ");
        return scannerData.nextInt();
    }

    public static String dateTimeToString(LocalDateTime dateTime) {
        return DATE_TIME_FORMATTER.format(dateTime);
    }
}


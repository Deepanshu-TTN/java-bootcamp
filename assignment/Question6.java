package assignment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        program2();
    }

    private static void program1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter date 1: ");
        LocalDate date1 = LocalDate.parse(scanner.nextLine().strip());
        System.out.print("Enter date 2: ");
        LocalDate date2 = LocalDate.parse(scanner.nextLine().strip());
        if (date2.isAfter(date1)) System.out.println(date2 + " comes after " + date1);
        else System.out.println(date1 + " comes after " + date2);
    }

    private static void program2() {
        ZoneId usPacific = ZoneId.of("US/Pacific");
        ZoneId chat = ZoneId.of("NZ-CHAT");
        ZoneId kolkata = ZoneId.of("Asia/Kolkata");

        LocalDateTime now = LocalDateTime.now();
        System.out.println("US/Pacific datetime: " + ZonedDateTime.of(now, usPacific).format(DateTimeFormatter.ISO_DATE));
        System.out.println("CHAT datetime: " + ZonedDateTime.of(now, chat).format(DateTimeFormatter.ISO_DATE));
        System.out.println("Kolkata datetime: " + ZonedDateTime.of(now, kolkata).format(DateTimeFormatter.ISO_DATE));
    }
}

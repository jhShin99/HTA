package ex11.ex11_make_calendar;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class This_LocalDate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("연도를 입력하세요 (예: 2024): ");
        int year = sc.nextInt();
        System.out.print("월을 입력하세요 (1-12): ");
        int month = sc.nextInt();

        LocalDate current = LocalDate.of(year, month, 1);

        int dayOfWeekValue = current.getDayOfWeek().getValue();
        int lastDay = current.lengthOfMonth();

        System.out.println("\n\t\t\t" + year + "년 " + month + "월");
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        int maxTab = dayOfWeekValue%7;
        for (int i = 1; i <= maxTab; i++) {
            System.out.print("\t");
        }

        for (int day = 1; day <= lastDay; day++) {
            System.out.printf("%d\t", day);
            if ((day + dayOfWeekValue) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

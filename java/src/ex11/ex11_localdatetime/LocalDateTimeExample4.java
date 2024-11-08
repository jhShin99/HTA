package ex11.ex11_localdatetime;

import java.time.LocalDate;

public class LocalDateTimeExample4 {

    public static void main(String[] args) {
        String dateStr = "2024-08-02";
        LocalDate date = LocalDate.parse(dateStr);

        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        //결과 출력
        System.out.println("년도: " + year);
        System.out.println("월: " + month);
        System.out.println("일: " + day);
    }
}

package ex11.ex11_localdate;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateExample1 {

    public static void main(String[] args) {
        // 기본 시간대의 시스템 시계에서 현재 날짜를 가져옵니다.
        LocalDate current = LocalDate.now();

        int year = current.getYear(); // 년도를 가져옵니다.
        int month = current.getMonthValue(); // 월을 가져옵니다. (1~12)
        int day = current.getDayOfMonth(); // (1~31)

        System.out.println("년도 = " + year);
        System.out.println("월 = " + month);
        System.out.println("날 = " + day);

        int days = current.getDayOfYear(); // 1 ~ 365, 윤년은 1 ~ 366
        System.out.println("1년 365일 중 " + days + "일");

        DayOfWeek enums = current.getDayOfWeek();
        int dayOfWeek = enums.getValue(); // the day-of-week, from 1 (Monday) to 7 (Sunday)
        System.out.println(enums + ":" + dayOfWeek);

        // 특정 날짜 생성
        LocalDate special = LocalDate.of(2024,1,30);
        year = special.getYear();
        month = special.getMonthValue();
        day = special.getDayOfMonth();

        System.out.println("년도 = " + year);
        System.out.println("월 = " + month);
        System.out.println("날 = " + day);
        days = special.getDayOfYear();
        System.out.println("1년 365일 중 " + days + "일");
    }
}

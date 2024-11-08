package ex11.ex11_localdatetime;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class LocalDateTimeExample1 {

    public static void main(String[] args) {
        //현재 날짜와 시간 가져오기
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 년도, 월, 일, 시, 분, 초 출력
        int year = currentDateTime.getYear();
        int month = currentDateTime.getMonthValue();
        int day = currentDateTime.getDayOfMonth();
        DayOfWeek dayOfWeek = currentDateTime.getDayOfWeek();
        int hour = currentDateTime.getHour();
        int minute = currentDateTime.getMinute();
        int second = currentDateTime.getSecond();

        System.out.println("년도: " + year);
        System.out.println("월: " + month);
        System.out.println("일: " + day);

        System.out.println("요일: " + dayOfWeek);
        System.out.println("요일을 숫자로: " + dayOfWeek.getValue()); // 월요일 1, 화요일 2, 수요일 3, 목요일 4, ...

        System.out.println("시: " + hour);
        System.out.println("분: " + minute);
        System.out.println("초: " + second);

    }
}

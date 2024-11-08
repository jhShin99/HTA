package ex11.ex11_localdatetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample5 {

    public static void main(String[] args) {
        // 커스텀 형식의 날짜 문자열
        String dateStr = "02-14-2025";

        // DateTimeFormatter를 사용하여 문자열 형식 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        // 지정된 형식의 날짜 문자열 파싱
        LocalDate date = LocalDate.parse(dateStr, formatter);

        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        //결과 출력
        System.out.println("년도: " + year);
        System.out.println("월: " + month);
        System.out.println("일: " + day);
    }
}

package ex11.ex11_localdatetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample3 {

    public static void main(String[] args) {
        /**
         * LocalDateTime 객체는 불변(immutable)입니다.
         * 즉, 한번 생성되면 그 값을 변경할 수 없습니다.
         * 이는 멀티스레드 환경에서 안전하게 사용할 수 있다는 장점이 있습니다.
         */
        LocalDateTime now = LocalDateTime.now();
        print(now);

        //now.plusDays(5).plusMonths(1) 수행하면 새로운 객체를 생성해서 newDateTime에 대입합니다.
        LocalDateTime newDateTime = now.plusDays(5).plusMonths(1);
        print(newDateTime);

        LocalDateTime now2 = LocalDateTime.now();
        print(now2);

        LocalDateTime newDateTime2 = now2.minusHours(3).minusMinutes(30);
        print(newDateTime2);

    }

    public static void print(LocalDateTime currentDateTime) {
        // 원하는 형식 정의하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd EEEE HH:mm:ss");

        // 날짜와 시간을 형식에 맞춰 문자열로 변환하기
        String formattedDateTime = currentDateTime.format(formatter);

        // 결과 출력
        System.out.println(formattedDateTime);
    }
}

package ex11.ex11_localdatetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample2 {

    public static void main(String[] args) {

        // 현재 날짜와 시간 가져오기
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 원하는 형식 정의하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd EEEE HH:mm:ss");

        // 날짜와 시간을 형식에 맞춰 문자열로 변환하기
        String formattedDateTime = currentDateTime.format(formatter);

        //결과 출력
        System.out.println(formattedDateTime);

    }
}

package ex11.ex11_date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatExample1_Date {

    public static void main(String[] args) {
        // 현재 시스템 날짜와 시간 구하는 방법
        // 클래스 Date 이용하는 방법 - 현재 시스템 날짜와 시간 구합니다.
        Date d = new Date();
        System.out.println("Date 사용 : " + d);

        SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sd2 = new SimpleDateFormat("yyyy년MM월dd일");
        System.out.println(sd1.format(d)); //yyyy-MM-dd 형태로 출력
        System.out.println(sd2.format(d)); //yyyy년MM월dd일 형태로 출력

        /**
         * 생성자의 매개변수는 날짜와 시간의 포맷을 작성하여 넘겨줍니다.
         * 패턴문자 의미
         * y       년
         * M       월
         * d       일
         * D       일(1~365)
         * E       요일
         * a       오전/오후
         * H       시(0~23)
         * h       시(1~12)
         * m       분
         * s       초
         * S       1/1000초
         */

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일 a HH시 mm분 ss초 E요일");
        System.out.println(sdf1.format(d));


    }
}

package ex16.ex16_system_arraycopy;

import java.text.SimpleDateFormat;

public class SystemCurrentTimeMillisSimpleDateFormat {

    public static void main(String[] args) {
        //1970년 1월 1일 00:00:00 GMT부터 현재까지의 시간을 밀리초(milliseconds) 단위로 반환
        long time1 = System.currentTimeMillis(); // 현재 시간 측정
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일 a HH시 mm분 ss초 SSS밀리초 E요일");
        System.out.println(sdf1.format(time1));
    }
}

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

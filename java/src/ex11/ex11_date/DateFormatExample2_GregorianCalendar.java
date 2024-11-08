package ex11.ex11_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateFormatExample2_GregorianCalendar {

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();

        // calendar.getTime() : calendar 객체가 가지고 있는 날짜와 시간과 똑같은
        // 정보를 갖는 Date 객체를 만들어서 리턴하는 메서드입니다.
        System.out.println(calendar.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 dd일 a h시 m분 s초 E요일");
        System.out.println(sdf.format(calendar.getTime()));
    }
}

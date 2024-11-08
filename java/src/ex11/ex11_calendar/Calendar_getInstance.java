package ex11.ex11_calendar;

import java.util.Calendar;

public class Calendar_getInstance {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        print(now);

        now.set(2025, 1, 14);
        print(now);
    }

    public static void print(Calendar now) {
        String[] no = {"일", "월", "화", "수", "목", "금", "토"};
        String[] ampm = {"오전", "오후"};
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH)+1;
        int date = now.get(Calendar.DATE);
        int ap = now.get(Calendar.AM_PM);
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        int yoil = now.get(Calendar.DAY_OF_WEEK);
        System.out.printf("%d년 %d월 %d일 %s %d:%d:%d %s요일입니다.\n", year, month, date, ampm[ap], hour, minute, second, no[yoil-1]);
    }
}

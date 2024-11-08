package ex11.ex11_calendar;

import java.util.Calendar;

public class CalMain {

    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH)+1;
        int date = today.get(Calendar.DATE);
        String amPm = today.get(Calendar.AM_PM) == 0 ? "오전" : "오후";
        int hour = today.get(Calendar.HOUR);
        int minute = today.get(Calendar.MINUTE);
        int second = today.get(Calendar.SECOND);
        int day = today.get(Calendar.DAY_OF_WEEK);

        String dayOfWeek = "";
        switch (day) {
            case 1:
                dayOfWeek = "일";
                break;
            case 2:
                dayOfWeek = "월";
                break;
            case 3:
                dayOfWeek = "화";
                break;
            case 4:
                dayOfWeek = "수";
                break;
            case 5:
                dayOfWeek = "목";
                break;
            case 6:
                dayOfWeek = "금";
                break;
            case 7:
                dayOfWeek = "토";
                break;
        }
        System.out.printf("%d년 %d월 %d일 %s %d:%d:%d %s요일입니다.", year, month, date, amPm, hour, minute, second, dayOfWeek);
    }
}

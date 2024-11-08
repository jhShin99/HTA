package ex11.ex11_make_calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class This_Calendar_for {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 년도, 달 출력 받기
        System.out.print("연도를 입력하세요 (예: 2024): ");
        int year = sc.nextInt();
        System.out.print("월을 입력하세요 (1-12): ");
        int month = sc.nextInt();
        sc.close();

        Calendar c = new GregorianCalendar(year, month - 1, 1);
        int lastday = c.getActualMaximum(Calendar.DATE);
        int day_of_week = c.get(Calendar.DAY_OF_WEEK);

        String[] yoil = {"일", "월", "화", "수", "목", "금", "토"};
        System.out.print("\t\t\t" + c.get(Calendar.YEAR) + "년  ");
        System.out.println((c.get(Calendar.MONTH)+1) + "월" + "\n");
        for (int i = 0; i < yoil.length; i++) {
            System.out.print(yoil[i] + "\t");
        }
        System.out.println();

        /**
         * 공백을 찍어요
         *
         * c.get(Calendar.DAY_OF_WEEK)=1 일요일 공백 없어요.
         * c.get(Calendar.DAY_OF_WEEK)=2 월요일 공백 한개
         * c.get(Calendar.DAY_OF_WEEK)=3 화요일 공백 두개
         */
        for (int i = 1; i < day_of_week; i++) {
            System.out.print("\t");
        }

        for (int i = 1; i <= lastday; i++) {   // day_of_week=1 이면 i=(7,14,21,28)일때 줄 바뀌어요

            System.out.print(i + "\t");
            if ((day_of_week + i) % 7 == 1) {
                System.out.println("\n");
            }
        }
    }
}

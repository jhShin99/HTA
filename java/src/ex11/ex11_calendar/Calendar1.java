package ex11.ex11_calendar;

import java.util.Calendar;

/**
 * Calendar는 추상 클래스로 이렇게 사용할 수 없습니다.
 * 1. Calendar c = new Calendar;
 *
 * 2. Calendar 사용법 두가지
 *    하나) 정적 메소드를 이용해서 사용하는 방법
 *          Calendar c1 = Calendar.getInstance();
 *          getInstance() : Calendar 클래스를 구현한 클래스의 인스턴스를 반환
 *          getInstance() 메서드는 달력 필드가 현재 날짜 및 시간으로 초기화 된 Calendar 객체를 반환합니다.
 *     둘)  업캐스팅 방법(자식의 주소를 부모의 자료형을 가진 변수에 저장)
 * 3. GregorianCalendar c = new GregorianCalendar();
 */
public class Calendar1 {
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();

        System.out.println("이 해의 년도 : " + today.get(Calendar.YEAR));
        System.out.println("월 (0~11, 0:1월): " + today.get(Calendar.MONTH));
        System.out.println("월 (0~11, 0:1월): " + (today.get(Calendar.MONTH)+1));
        System.out.println("이 해의 몇 째 주: " + today.get(Calendar.WEEK_OF_YEAR));
        System.out.println("이 달의 몇 째 주: " + today.get(Calendar.WEEK_OF_MONTH));

        //DATE와 DAY_OF_MONTH는 같다.
        System.out.println("이 달의 며칠: " + today.get(Calendar.DATE));
        System.out.println("이 달의 며칠: " + today.get(Calendar.DAY_OF_MONTH));
        System.out.println("이 해의 며칠: " + today.get(Calendar.DAY_OF_YEAR));

        //1: 일요일, 2: 월요일, ... 7. 토요일
        System.out.println("요일(1~7, 1: 일요일): " + today.get(Calendar.DAY_OF_WEEK));
        System.out.println("이 달의 몇번째 요일: " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("오전_오후(0:오전, 1:오후): " + today.get(Calendar.AM_PM));
        System.out.println("시간(0~11): " + today.get(Calendar.HOUR));
        System.out.println("시간(0~23): " + today.get(Calendar.HOUR_OF_DAY));
        System.out.println("분(0~59): " + today.get(Calendar.MINUTE));
        System.out.println("초(0~59): " + today.get(Calendar.SECOND));

        // 이 달의 마지막 일을 찾습니다.
        System.out.println("이 달의 마지막 날: " + today.getActualMaximum(Calendar.DATE));
    }
}

package ex11.ex11_localtime;

import java.time.LocalTime;
import java.time.ZoneId;

public class LocalTimeExample1 {

    public static void main(String[] args) {

        //시스템 시계에서 현재 시간을 가져옵니다.
        LocalTime current = LocalTime.now();

        int hour = current.getHour();
        int minute = current.getMinute();
        int second = current.getSecond();

        System.out.println("시간=" + hour + ":" + minute + ":" + second);

        //타임존 사용
        LocalTime currentTimeInParis = LocalTime.now(ZoneId.of("Europe/Paris"));
        System.out.println("The current time in Paris is " + currentTimeInParis);
    }
}

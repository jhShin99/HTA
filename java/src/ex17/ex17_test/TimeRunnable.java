package ex17.ex17_test;

import java.text.SimpleDateFormat;

public class TimeRunnable implements Runnable {

    @Override
    public void run() {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일 a HH시 mm분 ss초 EEEE");

        while (true) {
            long time1 = System.currentTimeMillis(); // 현재 시간 측정
            System.out.println(sdf1.format(time1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println(ie.toString());
            }
        } //while
    } //run()
} //class

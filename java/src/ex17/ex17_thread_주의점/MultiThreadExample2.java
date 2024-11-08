package ex17.ex17_thread_주의점;

import ex17.ex17_thread.DigitThread;

public class MultiThreadExample2 {

    public static void main(String[] args) {
        Thread thread = new DigitThread(); // 쓰레드를 생성

        thread.start();
        thread.start();

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch);
        }

        System.out.println("스레드 이름 : " + Thread.currentThread().getName());
        /**
         * 하나의 스레드에 대해 두번 start() 메서드를 호출하면
         * java.lang.IllegalThreadStateException 에러 발생합니다.
         */
    }
}

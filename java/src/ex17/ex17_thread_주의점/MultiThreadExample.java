package ex17.ex17_thread_주의점;

/**
 * 알파벳과 숫자를 동시에 출력하는 멀티스레드 프로그램
 * thread.run(); 실행하는 경우
 * 쓰레드가 생성되지 않고 DigitThread 클래스의 run() 메서드를 호출한 것입니다.
 * 실행결과)
 * 0123456789 스레드 이름2 : main
 * ABCDEFGHIJKLMNOPQRSTUVWXYZ 스레드 이름:
 */
public class MultiThreadExample {
    public static void main(String[] args) {
        Thread thread = new DigitThread();
        thread.run();

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch);
        }
    }
}

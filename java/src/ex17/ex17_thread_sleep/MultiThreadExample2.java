package ex17.ex17_thread_sleep;

public class MultiThreadExample2 {
    public static void main(String[] args) {
        Thread thread = new DigitThread();
        thread.start();

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch);
            try {
                Thread.sleep(1000); //sleep 메소드 : 일정 시간이 경과되기를 기다리는 메소드.
                                         // 주어진 시간 동안 스레드를 일시 정지 상태로 만듭니다.
                                         // 주어진 시간이 지나면 자동적으로 실행 대기 상태가 됩니다.
                //public static void sleep(long millis) throws InterruptedException
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

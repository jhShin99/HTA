package ex17.ex17_thread_name;

public class MultiThreadExample {

    public static void main(String[] args) {
        Thread thread1 = new DigitThread();
        Thread thread2 = new DigitThread();
        Thread thread3 = new AlphabetThread();

        thread1.setName("digit1");
        thread2.setName("digit2");
        thread3.setName("alphabet");

        thread1.start();
        thread2.start();
        thread3.start();

        /**
         * Thread t = Thread.currentThread();
         * Thread의 정적 메서드인 currentThread()로 코드를 실행하는 현재 스레드의 참조를 얻을수 있습니다.
         * setName() 메서드로 스레드의 이름을 변경할 수 있고
         * getName() 메서드로 스레드의 이름을 가져올 수 있습니다.
         * 예) t.setName("스레드이름")
         * 예) t.getName();
         */
        System.out.println("스레드 이름 : " + Thread.currentThread().getName());

    }
}

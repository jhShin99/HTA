package ex17.ex17_thread_name;

public class AlphabetThread extends Thread {
    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("스레드 이름(alphabet) : " + Thread.currentThread().getName());
    }
}

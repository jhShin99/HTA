//Runable 인터페이스를 이용한 멀티스레드 프로그램
package ex17.ex17_runnable_interface;

//이 클래스는 Thread 클래스가 아닙니다.
public class SmallLetters implements Runnable {

    @Override
    public void run() {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            System.out.print(ch);
        }
    }
}

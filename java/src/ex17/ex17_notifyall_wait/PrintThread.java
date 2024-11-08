package ex17.ex17_notifyall_wait;


public class PrintThread extends Thread{

    private SharedArea sharedArea;

    PrintThread(SharedArea sharedArea) {
        this.sharedArea = sharedArea;
    }

    @Override
    public void run() {
        if (sharedArea.isReady() != true) { // 파이가 계산 중인 경우
            try {
                synchronized (sharedArea) {
                    sharedArea.wait(); //다른 스레드로부터 신호를 기다립니다.
                                       //파이의 계산이 끝나면 다른 스레드에서 신호를 보냅니다.
                }
            } catch (InterruptedException e) { // wait 메소드가 발생하는 익셉션 처리
                System.out.println(e.getMessage());
            }
        }
        System.out.println("PrintThread : " + sharedArea.getResult());
    }
}

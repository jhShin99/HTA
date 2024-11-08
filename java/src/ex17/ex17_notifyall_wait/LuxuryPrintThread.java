package ex17.ex17_notifyall_wait;


public class LuxuryPrintThread extends Thread{

    private SharedArea sharedArea;

    LuxuryPrintThread(SharedArea sharedArea) {
        this.sharedArea = sharedArea;
    }

    @Override
    public void run() {
        if (sharedArea.isReady() != true) { // 파이가 계산 중인 경우
            try {
                synchronized (sharedArea) {
                    sharedArea.wait(); // 신호를 기다립니다.
                }
            } catch (InterruptedException e) { // wait 메소드가 발생하는 익셉션 처리
                System.out.println(e.getMessage());
            }
        }
        System.out.println("*** π = " + sharedArea.getResult() + " ***");
        // π : ㅎ + 한자키
    }
}

package ex17.ex17_notifyall_wait;


public class CalcThread extends Thread {

    private SharedArea sharedArea;

    CalcThread(SharedArea sharedArea) {
        this.sharedArea = sharedArea;
    }

    @Override
    public void run() {
        double total = 0.0;
        // 파이를 계산하는 부분
        for (int cnt = 1; cnt < 1000000000; cnt += 2)
            if (cnt / 2 % 2 == 0)
                total += 1.0 / cnt;
            else
                total -= 1.0 / cnt;

        sharedArea.setResult(total * 4);
        sharedArea.setReady(true); // 파이 계산 끝났다라는 의미

        synchronized (sharedArea) {
            sharedArea.notifyAll(); // 기다리고 있는 모든 스레드로 신호를 보냅니다.
//            sharedArea.notify(); // wait 중인 쓰레드중 하나에게만 신호가 보내집니다.
        }
    }
}

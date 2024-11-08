package ex17.ex17_syn_problem;

public class PrintThread extends Thread{

    private SharedArea sharedArea;

    PrintThread(SharedArea sharedArea) {
        this.sharedArea = sharedArea;
    }

    @Override
    public void run() {
        for (int cnt = 0; cnt <= 2; cnt++) {
            int sum = sharedArea.getAccount1().getBalance() + sharedArea.getAccount2().getBalance();
            System.out.println("계좌 잔액 합계 : " + sum);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}

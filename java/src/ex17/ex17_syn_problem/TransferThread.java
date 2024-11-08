package ex17.ex17_syn_problem;

public class TransferThread extends Thread{
    private SharedArea sharedArea;

    TransferThread(SharedArea sharedArea) {
        this.sharedArea = sharedArea;
    }

    @Override
    public void run() {
       for (int cnt = 0; cnt < 12; cnt++) {
           sharedArea.getAccount1().withdraw(1000000);
           System.out.println("회사 계좌: 100만원 인출");
           sharedArea.getAccount2().deposit(1000000);
           System.out.println("직원 계좌: 100만원 입금");
       }
    }
}

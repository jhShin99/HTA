package ex17.ex17_syn_format;

public class TransferThread extends Thread{
    private SharedArea sharedArea;

    TransferThread(SharedArea sharedArea) {
        this.sharedArea = sharedArea;
    }

    @Override
    public void run() {
       for (int cnt = 0; cnt < 12; cnt++) {
           sharedArea.transfer();
       }
    }
}

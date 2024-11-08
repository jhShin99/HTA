package ex17.ex17_sharedarea_solution;

public class PrintThread extends Thread{

    private SharedArea sharedArea;

    PrintThread(SharedArea sharedArea) {
        this.sharedArea = sharedArea;
    }

    @Override
    public void run() {

        while(sharedArea.isReady() != true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }

        //공유 영역의 데이터를 출력
        System.out.println("공유 영역의 데이터 = " + sharedArea.getResult());
    }
}

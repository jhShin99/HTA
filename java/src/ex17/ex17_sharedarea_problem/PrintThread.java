package ex17.ex17_sharedarea_problem;

public class PrintThread extends Thread{

    private SharedArea sharedArea;

    PrintThread(SharedArea sharedArea) {
        this.sharedArea = sharedArea;
    }

    @Override
    public void run() {
        //공유 영역의 데이터를 출력
        System.out.println("공유 영역의 데이터 = " + sharedArea.getResult());
    }
}

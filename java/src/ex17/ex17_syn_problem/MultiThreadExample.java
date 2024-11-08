package ex17.ex17_syn_problem;

public class MultiThreadExample {

    public static void main(String[] args) {
        Account a1 = new Account("111-111-1111", "회사", 20000000);
        Account a2 = new Account("222-222-2222", "직원", 10000000);
        SharedArea area = new SharedArea(a1, a2);
        TransferThread thread1 = new TransferThread(area);
        PrintThread thread2 = new PrintThread(area);
        thread1.start();
        thread2.start();
    }
}

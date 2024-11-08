package ex09.ex09_downcasting_error;

public class RefTypeExample {

    public static void main(String[] args) {
        Account obj1 = new CheckingAccount("111-22-33333333", "홍길동", 1000000, "5555-6666-7777-8888");
        CheckingAccount obj2 = (CheckingAccount) obj1;
        try {
            int amount = obj2.pay("5555-6666-7777-8888", 470000);
            System.out.println("인출액: " + amount);
            System.out.println("카드번호: " + obj2.cardNo);
            System.out.println("잔액: " + obj2.balance);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

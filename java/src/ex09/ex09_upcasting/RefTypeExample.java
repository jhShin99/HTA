package ex09.ex09_upcasting;

public class RefTypeExample {

    public static void main(String[] args) {
        Account obj = new CheckingAccount("111-22-33333333", "홍길동", 47000, "1111-2222-3333-4444");
        try {
//            int amount = obj.pay("1111-2222-3333-4444", 470000);
//            System.out.println("인출액: " + amount);
//            System.out.println("카드번호: " + obj.cardNo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

package ex07.ex07_private_field;

public class Account2 {

    String accountNo;
    String ownerName;
    int balance;

    Account2(String accountNo, String ownerName, int balance) {
        this.accountNo = accountNo;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    void deposit(int amount) {
        balance += amount;
    }

    int withdraw(int amount) throws Exception{
        //Exception 클래스를 이용해서 예외를 발생시킵니다.
        if (balance < amount)
            throw new Exception("잔액이 부족합니다.");
        balance -= amount;
        return amount;
    }

    void printAccount() {
        System.out.println("계좌번호: " + accountNo);
        System.out.println("예금주 이름: " + ownerName);
        System.out.println("잔액: " + balance);
    }
}

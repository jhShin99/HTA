package ex07.ex07_private_field;

public class Account {

    String accountNo;
    String ownerName;
    int balance;

    Account(String accountNo, String ownerName, int balance) {
        this.accountNo = accountNo;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    void deposit(int amount) {
        balance += amount;
    }

    int withdraw(int amount) {
        if (balance < amount)
            return 0;
        balance -= amount;
        return amount;
    }

    void printAccount() {
        System.out.println("계좌번호: " + accountNo);
        System.out.println("예금주 이름: " + ownerName);
        System.out.println("잔액: " + balance);
    }
}

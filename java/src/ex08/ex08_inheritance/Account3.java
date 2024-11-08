package ex08.ex08_inheritance;

/**
 * 모든 클래스의 조상은 Object 클래스입니다.
 * 다른 클래스로부터 상속 받지 않는 모든 클래스들은 자동으로 Object 클래스로부터 상속 받습니다.
 */
public class Account3 {

    String accountNo;
    String ownerName;
    int balance;

    Account3(String accountNo, String ownerName, int balance) {
        this.accountNo = accountNo;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    void deposit(int amount) {
        balance += amount;
    }

    int withdraw(int amount) throws Exception {
        if (balance <amount)
            throw new Exception("잔액이 부족합니다.");
        balance -= amount;
        return amount;
    }
}

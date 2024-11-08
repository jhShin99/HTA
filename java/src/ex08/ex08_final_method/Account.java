package ex08.ex08_final_method;

    public class Account {

    public String accountNo;
    public String ownerName;
    public int balance;

    public Account(String accountNo, String ownerName, int balance) {
        this.accountNo = accountNo;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    /*final*/ int withdraw(int amount) throws Exception {
        if (balance <amount)
            throw new Exception("잔액이 부족합니다.");
        balance -= amount;
        return amount;
    }
}

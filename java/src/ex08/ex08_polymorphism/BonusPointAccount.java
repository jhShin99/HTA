package ex08.ex08_polymorphism;

public class BonusPointAccount extends Account {

    int bonusPoint;

    public BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
        super(accountNo, ownerName, balance);
        this.bonusPoint = bonusPoint;
    }

    @Override
    public void deposit(int amount) {
        super.deposit(amount); // balance += amount; // super.balance += amount;
        bonusPoint = (int)(amount * 0.001); // bonusPoint += amount * (1.0/1000)
    }

}

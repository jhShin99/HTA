package ex08.ex08_final_class;

public class CreditLineAccount extends Account {
    int creditLine;

    public CreditLineAccount(String accountNo, String ownerName, int balance, int creditLine) {
        super(accountNo, ownerName, balance);
        this.creditLine = creditLine;
    }
    @Override
    public int withdraw(int amount) throws Exception {
        if ((balance + creditLine) < amount)
            throw new Exception("인출이 불가능합니다.");
        balance -= amount;
        return amount;
    }
}

package ex08.ex08_overriding;

/**
 * 마이너스 통장 클래스
 * - 상속 받은 withdraw 메서드를 다시 구현(메서드 오버라이딩)하는 클래스
 *
 */
public class CreditLineAccount extends Account {
    int creditLine;

    public CreditLineAccount(String accountNo, String ownerName,int balance, int creditLine) {
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

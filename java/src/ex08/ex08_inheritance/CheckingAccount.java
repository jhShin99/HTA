package ex08.ex08_inheritance;

public class CheckingAccount extends Account{

    String cardNo;

    CheckingAccount() {
        super();
    }

    int pay(String cardNo, int amount) throws Exception {
        if (!cardNo.equals(this.cardNo) || (balance < amount))
            throw new Exception("지불이 불가능합니다.");
        return withdraw(amount);
    }
}

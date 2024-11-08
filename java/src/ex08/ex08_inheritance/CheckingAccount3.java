package ex08.ex08_inheritance;

public class CheckingAccount3 extends Account3 {

    String cardNo;

    CheckingAccount3(String accountNo, String ownerName, int balance, String cardNo) {
        // 파라미터 3개의 슈퍼 클래스 생성자 호출문
        // 반드시 생성자의 첫번째 명령문이어야 합니다.
        super(accountNo, ownerName, balance);
        this.cardNo = cardNo; //클래스 안에 선언된 필드 초기화
    }

    int pay(String cardNo, int amount) throws Exception {
        if (!cardNo.equals(this.cardNo) || (balance < amount))
            throw new Exception("지불이 불가능합니다.");
        return withdraw(amount);
    }
}

package ex07.ex07_private_field;

public class AccountMain {

    public static void main(String[] args) throws Exception{
        Account2 account = new Account2("111-222-33333333", "홍길동", 1000);
        account.printAccount();
        account.deposit(1000);
        account.printAccount();
        account.withdraw(5000);
        account.printAccount();

        
    }
}

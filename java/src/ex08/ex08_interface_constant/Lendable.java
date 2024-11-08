package ex08.ex08_interface_constant;

public interface Lendable {
    final static byte STATE_BORROWED = 1;
    final static byte STATE_NORMAL = 0;
    //대출한다.
    void checkOut(String borrower, String date) throws Exception;
    //반납한다.
    void checkIn();
}

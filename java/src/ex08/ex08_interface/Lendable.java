package ex08.ex08_interface;

public interface Lendable {
    final static byte STATE_BORROWED = 1;
    final static byte STATE_NORMAL = 0;
    //대출한다.
    void checkOut(String borrower, String date);
    //반납한다.
    void checkIn();
}

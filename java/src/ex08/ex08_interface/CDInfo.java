package ex08.ex08_interface;

public class CDInfo implements Lendable{
    String registerNo;
    String title;
    CDInfo(String registerNo, String title) {
        this.registerNo = registerNo;
        this.title = title;
    }

    @Override
    public void checkOut(String borrower, String date) {

    }

    @Override
    public void checkIn() {

    }
}

package ex08.ex08_interface_exception;


public class InterfaceExample2 {

    public static void main(String[] args) {
        SeparateVolume obj = new SeparateVolume("863ㅂ", "나무", "베르베르");
        printState(obj);
        try {
            obj.checkOut("수지", "2024-07-31");
            obj.checkOut("박보검","2024-07-31");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        printState(obj);
    }

    static void printState(SeparateVolume obj) {
        if (obj.state == Lendable2.STATE_NORMAL) {
            System.out.println("------------------------");
            System.out.println("대출상태: 대출가능!");
            System.out.println("------------------------");
        } else if (obj.state == Lendable.STATE_BORROWED) {
            System.out.println("------------------------");
            System.out.println("대출상태: 대출중");
            System.out.println("대출인: " + obj.borrower);
            System.out.println("대출일: " + obj.checkOutDate);
            System.out.println("------------------------");
        }
    }
}

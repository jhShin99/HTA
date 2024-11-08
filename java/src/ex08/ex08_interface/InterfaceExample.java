package ex08.ex08_interface;

public class InterfaceExample {

    public static void main(String[] args) {
        SeparateVolume obj1 = new SeparateVolume("863ㅂ774개", "개미","베르베르");
        obj1.checkOut("홍길동", "2024-07-31");
        obj1.checkIn();
    }
}

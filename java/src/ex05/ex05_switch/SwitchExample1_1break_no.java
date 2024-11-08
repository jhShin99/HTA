package ex05.ex05_switch;

public class SwitchExample1_1break_no {

    public static void main(String[] args) {
        int num = 2;
        switch (num) {
            case 1:
                System.out.println("안녕하세요~");
            case 2:
                System.out.println("맛점하세요~");
            case 3:
                System.out.println("퇴실 찍으세요~");
            default:
                System.out.println("수고 많으셨어요~");
        }
        System.out.println("끝.");
    }
}

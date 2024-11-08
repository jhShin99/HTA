package ex05.ex05_switch;

public class SwitchExample2_1_char2_12 {

    public static void main(String[] args) {
        char ch = 'A';

        switch (ch) {
            case 'A', 'a':
                System.out.println("사과");
                break;
            case 'P', 'p':
                System.out.println("배");
                break;
            case 'G', 'g':
                System.out.println("포도");
                break;
            default:
                System.out.println("?");
        }
        System.out.println("끝.");
    }
}

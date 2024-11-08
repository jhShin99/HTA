package ex05.ex05_switch;

public class SwitchExample2_1_char {

    public static void main(String[] args) {
        char ch = 'A';

        switch (ch) {
            case 'A':
            case 'a':
                System.out.println("사과");
                break;
            case 'P':
            case 'p':
                System.out.println("배");
                break;
            case 'G':
            case 'g':
                System.out.println("포도");
                break;
            default:
                System.out.println("?");
        }
        System.out.println("끝.");
    }
}

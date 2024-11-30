package ex05.ex05_break;

public class BreakExample1 {

    public static void main(String[] args) {

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                if (row == 1 && col == 3)
                    break;
                System.out.println("(" + row + ", " + col + ")");
            }
        }
        System.out.println("끝.");
    }
}

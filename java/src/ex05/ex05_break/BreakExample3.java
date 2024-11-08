package ex05.ex05_break;

public class BreakExample3 {

    public static void main(String[] args) {

        outerLoop:
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.println("(" + row + ", " + col + ")");
                if (row == 1 && col == 2)
                    break outerLoop;
            }
        }
        System.out.println("끝.");
    }
}

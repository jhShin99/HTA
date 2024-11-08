package ex05.ex05_for;

public class ForExample4_7calendar6_2024_07 {

    public static void main(String[] args) {
        System.out.println("============== 2024 7월 ===============");
        for (int i = 0; i <= 31; i++) {
            if (i <= 0) {
                System.out.printf("%5s", "");
            } else {
                System.out.printf("%5d", i);
            }
            if (i % 7 == 6)
                System.out.println();
        }
    }
}

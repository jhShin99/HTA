package ex05.ex05_for;

public class Practice2 {

    public static void main(String[] args) {
        for (int i = 1; i <= 31; i++) {
            System.out.printf("%5d", i);
            if (i % 7 == 0)
                System.out.println();
        }
        System.out.println();
        System.out.println("=====================================");
        for (int i = 1; i <= 31; i++) {
            System.out.printf("%-5d", i);
            if (i % 7 == 0)
                System.out.println();
        }
        System.out.println();
        System.out.println("=========== 2024년 7월 ==============");
        System.out.printf("%10d", 1);
        for (int i=2; i<=6; i++) {
            System.out.printf("%5d", i);
        }
        System.out.println();
        int cnt=0;
        for (int i=7; i<=31; i++) {
            System.out.printf("%5d", i);
            cnt++;
            if (cnt % 7 == 0)
                System.out.println();
        }

    }
}

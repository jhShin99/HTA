package ex06.ex06_method_intro_return;

import java.util.Scanner;

public class Practice3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("두 개의 정수를 입력하세요? ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("max = " + max(a,b));
        System.out.println("min = " + min(a,b));
    }

    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int min(int a, int b) {
        return Math.min(a, b);
    }
}

package ex05.ex05_if;

import java.util.Scanner;

public class IfExample5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        if (num < 10) {
            System.out.println("num의 값은 10 미만입니다.");
        } else if (num <100) {
            System.out.println("num의 값은 10 이상 100 미만입니다.");
        } else if (num < 1000) {
            System.out.println("num의 값은 100 이상 1000 미만입니다.");
        } else {
            System.out.println("num의 값은 1000 이상입니다.");
        }
    }
}

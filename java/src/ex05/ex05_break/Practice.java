package ex05.ex05_break;

import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("지역입력(exit=q)> ");
            String location = sc.next();
            if (location.equals("q"))
                break;
            System.out.println("입력하신 지역은 " + location + "입니다.");
        } while (true);
        System.out.println("끝.");
        sc.close();
    }
}

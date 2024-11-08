package ex11.ex11_scanner;

import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("주소를 입력해보세요> ");
        System.out.println(sc.nextLine());
        sc.close();
    }
}

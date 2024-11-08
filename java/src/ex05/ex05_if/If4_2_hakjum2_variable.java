package ex05.ex05_if;

import java.util.Scanner;

public class If4_2_hakjum2_variable {

    public static void main(String[] args) {
        System.out.print("점수를 입력하세요> ");
        Scanner sc = new Scanner(System.in);
        String grade = "";
        int score = sc.nextInt();
        int mok = score/10;

        if (mok == 9 || mok == 10)
            grade = "A";
        else if (mok == 8)
            grade = "B";
        else if (mok == 7)
            grade = "C";
        else if (mok ==6)
            grade = "D";
        System.out.println(grade + "학점");
        System.out.println("끝.");
        sc.close();
    }
}

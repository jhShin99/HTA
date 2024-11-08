package ex05.ex05_if;

import java.util.Scanner;

public class If4_1_hakjum2_variable {

    public static void main(String[] args) {
        System.out.print("점수를 입력하세요>");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        String grade = "";

        if (score >= 90)
            grade = "A";
        else if (score >= 80)
            grade = "B";
        else if (score >= 70)
            grade = "C";
        else if (score >= 60)
            grade = "D";
        else
            grade = "F";

        System.out.println(grade + "학점");
    }
}

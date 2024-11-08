package ex05.ex05_switch;

import java.util.Scanner;

public class SwitchExample1_2hakjum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        int x = score / 5;
        String grade;

        switch (x) {
            case 20, 19:
                grade = "A+";
                break;
            case 18:
                grade = "A0";
                break;
            case 17:
                grade = "B+";
                break;
            case 16:
                grade = "B0";
                break;
            case 15:
                grade = "C+";
                break;
            case 14:
                grade = "C0";
                break;
            case 13:
                grade = "D+";
                break;
            case 12:
                grade = "D0";
                break;
            default:
                grade = "F";
        }

        System.out.println(grade + "학점");
    }
}

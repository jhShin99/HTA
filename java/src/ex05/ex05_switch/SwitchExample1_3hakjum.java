package ex05.ex05_switch;

import java.util.Scanner;

public class SwitchExample1_3hakjum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        int x = score / 5;
        String grade = switch (x) {
            case 20, 19 -> "A+";
            case 18 -> "A0";
            case 17 -> "B+";
            case 16 -> "B0";
            case 15 -> "C+";
            case 14 -> "C0";
            case 13 -> "D+";
            case 12 -> "D0";
            default -> "F";
        };

        System.out.println(grade + "학점");
    }
}

package ex06.ex06_array;

import java.util.Scanner;

public class Practice3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 5개를 입력하세요?");
        int[] score = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            score[i] = sc.nextInt();
            sum += score[i];
        }
        System.out.println("합 = " + sum);
        double average = sum / (double) 5;
        System.out.println("평균 = " + average);

    }
}

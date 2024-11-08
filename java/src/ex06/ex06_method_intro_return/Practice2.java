package ex06.ex06_method_intro_return;

import java.util.Scanner;

public class Practice2 {

    public static void main(String[] args) {
        int inputData = input();
        int result = abs(inputData);

        System.out.println("절대값 : " + result);
    }

    public static int input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static int abs(int data) {
        if (data < 0)
            data = -data;
        return data;
//        return Math.abs(data);
    }
}

package ex06.ex06_array;

import java.util.Scanner;

public class Practice5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 5개를 입력하세요? ");
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }

        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }
}

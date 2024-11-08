package ex06.ex06_method_intro_return;

import java.util.Scanner;

public class Practice4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] data = new int[5];
        for (int i = 0; i < 5; i++) {
            data[i] = sc.nextInt();
        }

        int max2 = max(data);
        int min2 = min(data);

        System.out.println("max2 = " + max2);
        System.out.println("min2 = " + min2);
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max)
                max = i;
        }

        return max;
    }

    public static int min(int[] arr) {
        int min = arr[0];
        for (int i : arr) {
            if (i < min)
                min = i;
        }

        return min;
    }
}

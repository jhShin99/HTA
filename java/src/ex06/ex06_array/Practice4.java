package ex06.ex06_array;

import java.util.Scanner;

public class Practice4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];

        for (int i=0; i<n; i++) {
            data[i] = sc.nextInt();
        }

        int max, min;
        max = data[0];
        min = data[0];

        for (int x : data) {
            if (x > max)
                max = x;
            if (x < min)
                min = x;
        }

        System.out.println("max = " + max);
        System.out.println("min = " + min);

    }
}

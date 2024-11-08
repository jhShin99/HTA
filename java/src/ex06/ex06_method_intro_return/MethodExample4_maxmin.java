package ex06.ex06_method_intro_return;

import java.util.Scanner;

public class MethodExample4_maxmin {

    public static void main(String[] args) {
        int[] data =new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 5개를 입력하세요?");
        for (int i = 0; i < data.length; i++) {
            data[i] = sc.nextInt();
        }

        int[] result = max_min(data);

        System.out.println("최댓값 = " + result[0]);
        System.out.println("최댓값 = " + result[1]);
    }

    public static int[] max_min(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        for (int a : arr) {
            max = Math.max(a, max);
            min = Math.min(a, min);
        }

        return new int[]{max, min};
    }
}

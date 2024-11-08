package ex15.ex15_hasmap_test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

//    static int[] max_min(int[] data) {
//        int[] result = {data[0], data[0]};
//
//        for (int i = 1; i < data.length; i++) {
//            if (result[0] < data[i]) result[0] = data[i]; //max
//            if (result[1] > data[i]) result[1] = data[i]; //min
//        }
//        return result;
//    }

    static HashMap<String, Integer> max_min(int data[]) {
        HashMap<String, Integer> m = new HashMap<>();
        int[] result = {data[0], data[0]};
        for (int i = 1; i < data.length; i++) {
            if (result[0] < data[i]) result[0] = data[i]; //max
            if (result[1] > data[i]) result[1] = data[i]; //min
        }

        m.put("max", result[0]);
        m.put("min", result[1]);
        return m;
    }

    public static void main(String[] args) {
        int[] data = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 5개를 입력하세요?");
        for (int i = 0; i < data.length; i++) {
            data[i] = sc.nextInt();
        }

        HashMap<String, Integer> m = max_min(data);
        System.out.println("최댓값 = " + m.get("max"));
        System.out.println("최솟값 = " + m.get("min"));

        sc.close();
    }
}

package ex06.ex06_array;

import java.util.Arrays;

public class ArrayExample1 {

    public static void main(String[] args) {
        int[] arr;
        arr = new int[10];

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = arr[0] + arr[1];

        String array = Arrays.toString(arr);
        System.out.println(array);

//        System.out.println(arr[10]);

    }
}

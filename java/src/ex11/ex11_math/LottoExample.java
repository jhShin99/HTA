package ex11.ex11_math;

import java.util.Arrays;

public class LottoExample {

    public static void main(String[] args) {
        //1부터 45까지 정수 범위에 속하는 난수 만들기
        int[] arr = new int[6];
        int num;
        for (int i = 0; i < 6; i++) {
            num = (int)(Math.random()*45)+1;
            arr[i] = num;
            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) {
                    arr[j] = (int)(Math.random()*45)+1;
                    j -= 1;
                }
            }
        }
        Arrays.sort(arr);
        System.out.println("======== 정렬 후 ========");
        System.out.println(Arrays.toString(arr));
    }
}

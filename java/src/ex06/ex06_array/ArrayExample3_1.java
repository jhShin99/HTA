package ex06.ex06_array;

public class ArrayExample3_1 {

    public static void main(String[] args) {
        System.out.println("===== 방법1 =====");

        int[] arr = new int[5];

        //배열 사용
        arr[0] = 10; arr[1] = 20; arr[2] = 30; arr[3] = 40; arr[4] = 50;
        for (int i=0; i<arr.length; i++) {
            System.out.println("arr[" + i + "]=" + arr[i]);
        }
    }
}

package ex06.ex06_array;

public class ArrayExample2_init {

    public static void main(String[] args) {
        int[] arr = new int[10];

        System.out.println("=========10개의 println()이용===========");
        System.out.println("arr[" + 0 + "]=" + arr[0]);
        System.out.println("arr[" + 1 + "]=" + arr[1]);
        System.out.println("arr[" + 2 + "]=" + arr[2]);
        System.out.println("arr[" + 3 + "]=" + arr[3]);
        System.out.println("arr[" + 4 + "]=" + arr[4]);
        System.out.println("arr[" + 5 + "]=" + arr[5]);
        System.out.println("arr[" + 6 + "]=" + arr[6]);
        System.out.println("arr[" + 7 + "]=" + arr[7]);
        System.out.println("arr[" + 8 + "]=" + arr[8]);
        System.out.println("arr[" + 9 + "]=" + arr[9]);

        System.out.println("=============for문 이용=================");
        for (int i = 0; i < 10; i++) {
            System.out.println("arr[" + i + "]=" + arr[i]);
        }
    }
}

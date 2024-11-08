package ex06.ex06_method;

public class MethodExample12 {

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        print(num);
        int hap = hap(1, 10);
        System.out.println(hap);
    }

    public static void print(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static int hap(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i ++) {
            sum += i;
        }

        return sum;
    }
}

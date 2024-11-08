package ex06.ex06_array;

public class ForExample1 {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        for (int cnt = 0; cnt < arr.length; cnt++) {
            int num = arr[cnt];
            System.out.println(num);
        }
        System.out.println("End.");
    }
}

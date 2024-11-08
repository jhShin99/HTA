package ex06.ex06_method_intro_return;

public class MethodExample2 {

    public static void main(String[] args) {
        int result = hap(1,100);
        System.out.println("1. result = " + result);
    }

    public static int hap(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }

        return sum;
    }
}

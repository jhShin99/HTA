package ex06.ex06_method_intro_return;

public class MethodExample3 {

    public static void main(String[] args) {
        System.out.println("출력문 안에서 호출 : " + hap(1,10));
    }

    public static int hap(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}

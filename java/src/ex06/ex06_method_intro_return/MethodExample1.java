package ex06.ex06_method_intro_return;

public class MethodExample1 {

    public static void main(String[] args) {
        hap(1,100); // 결과가 콘솔창에 출력되지 않음
    }

    public static int hap(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }

        return sum;
    }
}

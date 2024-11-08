package ex21.ex21_stream;

public class Exam가변인자 {

    public static void main(String[] args) {
        int sum1 = sum(1,2,3); //3개의 인수를 전달
        int sum2 = sum(10,20); //2개의 인수를 전달
        int sum3 = sum(4,5,6,7,8); //5개의 인수를 전달

        System.out.println("Sum1: " + sum1); //출력: Sum1: 6
        System.out.println("Sum2: " + sum2); // 출력: Sum2: 30
        System.out.println("Sum3: " + sum3); // 출력: Sum3: 30
    }

    /**
     * 가변인자(Varargs)는 메서드가 가변적인 수의 인수를 받을 수 있도록 해주는 기능입니다.
     * 가변인자는 메서드를 정의할 때 인수의 개수를 미리 알 수 없을 때 유용하게 사용할 수 있습니다.
     * 가변인자는 메서드의 매개변수 타입 뒤에 ...을 붙여서 선언합니다.
     * 매개변수가 여러 개인 경우 가변인자는 마지막 매개변수로 위치해야 합니다.
     * 메서드에서 가변인자는 하나만 사용할 수 있습니다.
     */
    //가변인자를 사용한 메서드 정의
    public static int sum(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static void print(String v, int... numbers) {

    }
    //The variable argument type int of the method print must be the last parameter
    /*
    public static void print(int... numbers, String v) {

    }

    public static void print(String ...v, int... numbers) {

    }
    */
}

package ex06.ex06_method_overloading;

public class Method_overloading {

    public static void print() {
        System.out.println("print() 메서드 입니다.");
    }

    public static void print(int num) {
        System.out.println("print(int num)메서드 입니다.");
    }

    public static void print(int num, char data) {
        System.out.println("print(int num, char data)메서드 입니다.");
    }

    // 매개변수 두 개를 갖는 메서드 - 위와 다른점은 매개변수 자료형의 순서가 다릅니다.
    public static void print(char data, int num) {
        System.out.println("print(int num, char data)메서드 입니다.");
    }
}

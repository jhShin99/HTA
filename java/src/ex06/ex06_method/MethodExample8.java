package ex06.ex06_method;

public class MethodExample8 {

    public static void main(String[] args) {
        print('*'); // 메서드의 괄호안에 값을 넣어주면 됩니다.
        // 메서드를 정의한 곳에서 num을 값을 저장하기 위한 변수를 선언해 주어야 합니다.
    }

    public static void print(char character) {
        System.out.println("print() 메서드 입니다.");
        System.out.println("main() 메서드에서 전달받은 데이터의 값은 " + character + "입니다.");
    }
}

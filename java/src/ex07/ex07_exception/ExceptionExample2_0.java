package ex07.ex07_exception;

public class ExceptionExample2_0 {

    public static void main(String[] args) {
        int sum = 1 + -2;
        if (sum < 0) {
            new Exception("에러 발생"); //Exception 객체 생성
        }
        System.out.println(sum);
    }
}

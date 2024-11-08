package ex07.ex07_exception;

public class ExceptionExample1_4 {

    public static void main(String[] args) {
        int num1 = 3, num2 = 10;

        try {
            int result = num1 / num2;
            System.out.println("결과=" + result);
        } catch (ArithmeticException e) {
            String message = e.getMessage();
            System.out.println(message);
        } finally {
            System.out.println("여기까지 왔어요~");
        }
    }
}

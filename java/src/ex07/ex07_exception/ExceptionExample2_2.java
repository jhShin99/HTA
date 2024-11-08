package ex07.ex07_exception;

public class ExceptionExample2_2 {

    public static void main(String[] args) {
        int sum = 1 - 2;
        try {
            if (sum < 0) {
                throw new Exception("0보다 작습니다.");
            }
            System.out.println(sum);
        } catch (Exception e) {
            System.out.println("[catch] " + e.getMessage());
        }
    }
}

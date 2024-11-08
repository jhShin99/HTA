package ex07.ex07_exception;

public class ExceptionExample3_1 {

    public static void main(String[] args) throws Exception {
        int result = add(1, -2);
        System.out.println(result);
    }

    //throws Exception : throw에 의해 발생한 에러를 호출한 메서드로 넘깁니다.
    static int add(int a, int b) throws Exception {
        int result = a + b;
        if (result < 0)
            throw new Exception("0보다 작아 에러 발생합니다.");
        return result;
    }
}

package ex06.ex06_method_intro_return;

public class Practice1 {
    /**
     * 다음 조건을 만족하는 메서드를 정의해 보세요.
     * 1. 메서드 이름: add
     *    매개 변수: 정수형 2개
     *    기능: 매개 변수의 값을 더한다.
     *    반환값: 매개 변수의 값을 더한 값
     *    반환형: int
     *
     * 2. 1번에서 정의한 add 메서드를 호출합니다.
     *    인자값으로 3과 4를 사용합니다.
     *
     * 3. add() 메서드 호출 결과값을 출력합니다.
     */
    public static void main(String[] args) {
        System.out.println(add(3,4));
    }

    public static int add(int a, int b) {
        return a + b;
    }
}

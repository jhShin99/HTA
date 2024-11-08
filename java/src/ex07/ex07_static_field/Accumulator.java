package ex07.ex07_static_field;

public class Accumulator {

    public int total = 0;
    public static int grandTotal = 0; // 정적 필드를 선언하는 선언문

    public void accumulate(int amount) {
        total += amount;
        //정적 필드에 amount 파라미터 값을 더하는 대입문
        grandTotal += amount;
    }

    /**
     * 정적 메서드 안에서는 인스턴스 변수, 인스턴스 메서드 사용할 수 없습니다.
     * 인스턴스 변수와 인스턴스 메서드는 객체 생성시 사용할 수 있는 멤버들이기 떄문에
     * 인스턴스 생성과 관련없는 static 메서드 안에서는 사용할 수 없습니다.
     * 따라서 this도 사용할 수 없습니다.
     */

    public static int getGrandTotal() { // 정적 메서드 선언
//        total = 5;             // 에러 발생
//        accumulate(100);       // 에러 발생
        return grandTotal;
    }
}

package ex11.ex11_string;

public class StringExample2 {

    public static void main(String[] args) {
        /**
         * 자바에서 동등성(Equality)과 동일성(Identity)은 객체 지향 프로그래밍에서 중요한 개념입니다.
         * 1.동등성 (Equality):
         * 동등성은 두 객체가 내용적으로 동일한지를 비교하는 개념입니다.
         * 자바에서는 객체의 내용이 동일한지를 판단하기 위해 equals() 메서드를 사용합니다.
         * 이 메서드를 객체 클래스에서 오버라이딩하여 객체의 내용 비교 방법을 재정의할 수 있습니다.
         *
         * 2.동일성 (Identity):
         * 동일성은 두 객체가 메모리 상에서 정확히 같은 객체인지를 비교하는 개념입니ㅣ다.
         * 자바에서는 객체의 동일성을 판단하기 위해 == 연산자를 사용합니다.
         * 간단히 말해서, 동등성은 객체의 내용이 같은지를 비교하고, 동일성은 객체의 메모리 주소가 같은지를 비교합니다.
         */

        String str1 = "자바";
        String str2 = "자바";

        if (str1 == str2)
            System.out.println("str1 == str2 같음");
        else
            System.out.println("str1 == str2 다름");


    }
}

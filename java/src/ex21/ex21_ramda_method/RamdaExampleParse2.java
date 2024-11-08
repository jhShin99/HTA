package ex21.ex21_ramda_method;

//1. 람다식은 메서드를 하나의 식으로 표현한 것입니다.
public class RamdaExampleParse2 {
    public static void main(String[] args) {
        Parse2 p;

        //인터페이스 익명 구현 객체
        p = new Parse2() {
            @Override
            public boolean isSame(String a, String b) {
                return a.equals(b);
            }
        };

        System.out.println(p.isSame("1", "2"));

        p = (String a, String b) -> {
            return a.equals(b);
        };
        System.out.println(p.isSame("3","4"));

        // 방법 2.
        // 매개변수 타입은 실행 도중 대입하는 값에 따라 자동으로 추론할 수 있기 때문에 타입을 생략해도 됩니다.
        p = (a,b) -> {
            return a.equals(b);
        };
        System.out.println(p.isSame("5","6"));

        // 방법 3.
        // 실행문이 하나 있다면 중괄호 생략할 수 있습니다.
        // 단, 실행문이 하나의 return 문이라면 return 키워드도 생략해야 합니다.
        p = (a,b) -> a.equals(b);
        System.out.println(p.isSame("7","8"));

        // 방법 4. 람다식이 하나의 메서드만 호출하는 경우 메서드 참조(method reference) 방식으로 간단히 나타낼 수 있습니다.
        p = String::equals;
        System.out.println(p.isSame("9","9"));
    }
}

package ex14.ex14_wrapper;

public class Wrapper_boxing_unboxing_deprecated_valueOf {

    public static void main(String[] args) {

        //박싱 - 기본형 타입의 값을 객체로 변환
        //int -> Integer
        Integer obj1 = Integer.valueOf(12); //Integer 객체를 생성합니다.
        Integer obj2 = Integer.valueOf(7);

        //언박싱 - 객체를 기본형 타입의 값으로 변환
        //Integer -> int
        int n1 = obj1.intValue();
        int n2 = obj2.intValue(); //Integer객체 안에 int값을 가져옵니다.
        int sum = n1 + n2;
        System.out.println(sum);

        //String -> Integer
        Integer n02 = Integer.valueOf("20"); //박싱은 아닙니다.
                                    // "20"은 문자열로 기본형이 아닙니다.

        // Integer -> int
        int n3 = n02.intValue(); //언박싱 이루어짐, 이것으로 형변환이 이루어집니다.
        sum = n1 + n2 + n3;
        System.out.println(sum);

    }
}

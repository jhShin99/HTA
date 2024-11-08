package ex21.ex21_ramda_function;

import java.util.function.Predicate;

/**
 * java.util.function 패키지에 일반적으로 자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의해 놓았습니다.
 *
 * 3. Predicate<T>는 조건식을 표현하는 데 사용합니다.
 *    한개의 매개변수 T, 반환 타입이 boolean 입니다.
 *
 * @FunctionalInterface
 * public interface Predicate<T> {
 *     boolean test(T t);
 * }
 */
public class PredicateExample {

    public static void main(String[] args) {

        Predicate<String> a = s -> s.length()==0; //람다식
        System.out.println(a.test("100"));
    }
}

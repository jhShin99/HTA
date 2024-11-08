package ex21.ex21_ramda_function;

import java.util.function.BiFunction;

/**
 * java.util.function 패키지에 일반적으로 자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의해 놓았습니다.
 *
 * 5. BiFunction<T, U, R> 는 두 개의 매개변수(T, U), 반환값이 R 입니다.
 *
 * @FunctionalInterface
 * public interface BiFunction<T, U, R> {
 *     R apply(T t, U u);
 * }
 */
public class TwoBiFunctionExample {

    public static void main(String[] args) {

        BiFunction<String, Integer, Student> a = (name, no) -> new Student(name, no);
        Student s = a.apply("홍길동", 20);
        System.out.println(s);

        BiFunction<String, Integer, Student> b = Student::new; //메서드 참조
        Student s2 = b.apply("홍길동2", 30);
        System.out.println(s2);
    }
}

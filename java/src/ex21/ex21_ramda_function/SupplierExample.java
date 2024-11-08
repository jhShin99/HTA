package ex21.ex21_ramda_function;

import java.util.function.Supplier;

/**
 * java.util.function 패키지에 일반적으로 자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의해 놓았습니다.
 *
 * 4. Supplier<T> 는 매개변수는 없고 반환값이 T입니다.
 *
 * @FunctionalInterface
 * public interface Supplier<T> {
 *     T get();
 * }
 */
public class SupplierExample {

    public static void main(String[] args) {
        Supplier<Integer> a = () -> (int)(Math.random()*45 + 1);
        System.out.println(a.get());

        Supplier<Student> b = () -> new Student();

        Student s = b.get();

        s.setName("홍길동");
        s.setNo(11);
        System.out.println(s);

        Supplier<Student> c = Student::new; //메서드 참조

        Student s2 = c.get();
        s2.setName("홍길동2");
        s2.setNo(12);
        System.out.println(s2);
    }
}

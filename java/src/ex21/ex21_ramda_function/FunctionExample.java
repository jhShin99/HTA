package ex21.ex21_ramda_function;

import java.util.function.Function;

/**
 * java.util.function 패키지에 일반적으로 자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의해 놓았습니다.
 *
 * 2. Function<T,R> 는 한 개의 매개변수 T, 반환값이 R인 함수형 인터페이스
 * @FunctionalInterface
 * public interface Function<T, R> {
 *     R apply(T t)
 * }
 */
public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> a = i -> Integer.parseInt(i); //람다식
        int result = a.apply("100");
        System.out.println(result);

        Function<String, Integer> b = Integer::parseInt; //메서드 참조
        result = b.apply("200");

        System.out.println(result);

        Function<Integer, int[]> f = x -> new int[x]; //람다식
        int[] array = f.apply(4);
        System.out.println("생성된 배열갯수 = " + array.length);

        Function<Integer, int[]> f2 = int[]::new; //메서드 참조
        int[] array2 = f2.apply(5);
        System.out.println("생성된 배열갯수 = " + array2.length);
    }
}

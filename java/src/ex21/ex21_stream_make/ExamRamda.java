package ex21.ex21_stream_make;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 4. 람다식을 이용한 스트림 만들기
 * iterate(), generate()는 람다식을 매개변수로 받아서 람다식에 의해 계산되는 값들을 요소로 하는
 * 무한 스트림을 생성합니다. 그래서 예제에서는 limit()로 제한합니다.
 */
public class ExamRamda {

    public static void main(String[] args) {

        // 0부터 짝수 구하는 스트림 - 무한 스트림
        // Stream<Integer> evenStream = Stream.iterate(0, n->n+2); //0,2,4,6, ...
        // System.out.println("===== Stream.iterate(0, n->n+2) ===);
        // evenStream.forEach(System.out::println)l

        // 0부터 짝수 구하는 스트림 - limit(10)로 10개 구합니다.
        // iterate()는 초기값과 그 다음 값을 생성하는 규칙을 사용하여 무한 슽트림을 생성하는 방법입니다.
        // 0은 초기값으로 스트림의 첫 번째 요소입니다.
        // n -> n+2는 다음 값으로 이전 값 n에 2를 더해 다음 값을 생성하는 규칙을 정의합니다.
        Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2).limit(10);
        System.out.println("===== Stream.iterate(0, n->n+2).limit(10) =====");
        evenStream.forEach(System.out::println);

       //짝수 구하는 스트림을 이용해서 리스트에 저장하기
        List<Integer> list = Stream.iterate(0, n -> n + 2)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("===== List<Integer> list =====");
        list.forEach(System.out::println);

        /**
         * Stream.generate(Supplier<T> s) 메서드는 무한 스트림을 생성합니다.
         * 이 스트림의 각 요소는 주어진 Supplier에서 생성된 값으로 채워집니다.
         * public interface Supplier<T> {
         * T get();
         * }
         */

        //난수 구하는 스트림
        Stream<Double> randomStream = Stream.generate(Math::random).limit(10);
        System.out.println("===== Stream.generate(Math::random) =====");
        randomStream.forEach(System.out::println);
    }
}

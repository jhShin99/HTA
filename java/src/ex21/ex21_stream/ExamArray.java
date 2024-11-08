package ex21.ex21_stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 2. 배열을 이용한 스트림 만들기
 */
public class ExamArray {

    public static void main(String[] args) {
        Stream<String> s1 = Stream.of("a", "b", "c");
        s1.forEach(System.out::println);

        String[] names = new String[] {"a","b","c"};
        Stream<String> s2 = Stream.of(names);
        s2.forEach(System.out::println);

        Stream<String> s3 = Arrays.stream(names);
        s3.forEach(System.out::println);

        int[] ages = new int[] {20, 35, 30};
        IntStream s4 = IntStream.of(ages);
        s4.forEach(System.out::println);

        IntStream s5 = Arrays.stream(ages);
        s5.forEach(System.out::println);
    }
}

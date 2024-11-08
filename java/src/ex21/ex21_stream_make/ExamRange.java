package ex21.ex21_stream_make;

import java.util.stream.IntStream;

/**
 * 3. 특정 범위의 정수 이용한 스트림 만들기
 */
public class ExamRange {

    public static void main(String[] args) {
        /**
         * IntStream.range(int startInclusive, int endExclusive) :
         * 정수의 값을 startInclusive 부터 endExclusive-1까지 1씩 증가
         *
         * IntStream.rangeClosed(int startInclusive, int endInclusive)
         * 정수의 값을 startInclusive 부터 endExclusive까지 1씩 증가
         */

        System.out.println("==========IntStream.range(1,5)==========");
        IntStream ints = IntStream.range(1, 5); //1부터 4(5-1)까지의 정수를 갖는 스트림을 생성합니다.
        ints.forEach(System.out::println);

        System.out.println("==========IntStream.rangeClosed(10,15)==========");
        IntStream ints2 = IntStream.rangeClosed(10, 15); //10부터 15까지
        ints2.forEach(System.out::println);

        System.out.println("==========IntStream.range(1,5)==========");
        //Returns the count of elements in this stream
        long count = IntStream.range(1, 5).count();//1부터 4(5-1)까지의 정수를 갖는 스트림을 생성합니다.
        System.out.println(count);

        //sum() 메서드는 스트림의 모든 정수 요소를 더하여 합계를 계산합니다.
        System.out.println("==========IntStream.range(1,5).sum()==========");
        int sum = IntStream.range(1, 5).sum();
        System.out.println(sum);

        //skip() 메서드는 스트림의 처음 n개의 요소를 건너뛰고, 나머지 요소들로 새로운 스트림을 반환합니다.
        System.out.println("==========IntStream.range(1,5).skip(3)==========");
        IntStream int_sum = IntStream.range(1, 5).skip(3); //요소 3개를 건너뛰고 4만 스트림요소로 사용합니다.
        int_sum.forEach(System.out::println);

        /**
         * @FunctionalInterface
         * public interface IntPredicate {
         *            boolean test(int value);
         *            }
         */
        //filter() 메서드는 스트림의 각 요소를 조건에 따라 필터링합니다. 조건이 true인 요소만을 포함하는 새로운 스트림을 반환합니다.
        System.out.println("==========IntStream.range(1,5).filter(n -> n % 2 == 0);========== ");
        IntStream ints3 = IntStream.range(1, 5).filter(i -> i % 2 == 0);
        ints3.forEach(System.out::println);
        System.out.println("==========IntStream.range(1,5).filter(n -> n % 2 == 0);========== ");
        IntStream.range(1,5)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        //map(IntUnaryOperator mapper) 메서드는 스트림의 각 요소를 주어진 함수를 통해 변환합니다.
        /**
         * @FunctionalInterface
         * public interface IntUnaryOperator {
         *     int applyAsInt(int operand);
         *     }
         */
        System.out.println("==========IntStream.range(1,5).filter(n->n%2==0).map(n->n*2);==========");
        IntStream ints4 = IntStream.range(1, 5)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2); // 2,4 -> 4,8
        ints4.forEach(System.out::println);

        System.out.println("==========IntStream.range(1,5).filter(n->n%2==0).map(n->n*2).sum();==========");
        sum = IntStream.range(1,5)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .sum(); //2,4 -> 4,8
        System.out.println(sum);

    }
}

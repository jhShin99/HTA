package ex21.ex21_stream_make;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

/**
 * 3. 특정 범위의 정수 이용한 스트림 만들기
 */
public class ExamRange2 {

    public static void main(String[] args) {
        System.out.println("==========IntStream.range(1,1)==========");
        IntStream ints = IntStream.range(1, 1); // 비어있는 스트림
        ints.forEach(System.out::println);

        System.out.println("==========IntStream.range(1,1).average()==========");
        OptionalDouble avg = IntStream.range(1,1).average();
        //java.util.NoSuchElementException: No value present
        //System.out.println("Average: " + avg.getAsDouble());

        //average()의 반환형이 OptionalDouble 입니다.
        //만약 평균을 구하는데 비어있는 스트림인 경우 java.util.NoSuchElementException: No value present 오류 발생
        // 이 문제를 해결하기 위해 OptionalDouble를 사용합니다.
        //OptionalDouble의 isPresent() 메서드를 사용하여 값이 존재하는지 확인할 수 있습니다.
        //값이 존재하면 getAsDouble()을 호출하여 실제 값을 가져옵니다.
        System.out.println("==========IntStream.range(1,1).average()==========");
        OptionalDouble avg2 = IntStream.range(1,1).average();
        // OptionalDouble 사용
        if(avg2.isPresent()) {
            System.out.println("Average: " + avg2.getAsDouble());
        } else {
            System.out.println("No average available");
        }
    }
}

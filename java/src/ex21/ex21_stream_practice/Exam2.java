package ex21.ex21_stream_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exam2 {

    public static void main(String[] args) {
        //앞에서 사용한 Member 객체 3개를 이용해서 배열 만들기
        Member[] members = {
                new Member("홍길동", 21),
                new Member("자바", 30),
                new Member("이순신", 30),
        };

        //Member의 List 만들기
        List<Member> list = new ArrayList<>();

        //위에서 만든 List 크기 구하기
        System.out.println(list.size());

        //배열로 스트림 생성하기
        Stream<Member> stream = Stream.of(members);

        //스트림의 forEach()를 이용해서 배열의 각 요소를 List에 추가하기
        stream.forEach(list::add);

        //List의 forEach()로 모든 요소 출력하기
        list.forEach(System.out::println);

        //List 크기 출력하기
        System.out.println(list.size());

        /**
         * 1. list.stream()을 통해 리스트의 스트림을 생성합니다.
         *
         * 2. mapToInt(Member::getAge)
         * 스트림의 각 Member 객체에 대해 getAge 메서드를 호출하여 나이를 정수(int)로 매핑합니다.
         * 이 단계에서는 Member 객체의 스트림을 IntStream으로 변환합니다.
         * IntStream은 Java의 스트림 API에서 기본형 int를 위한 특화된 스트림 타입입니다.
         * IntStream 외에 LongStream, DoubleStream 등의 트고하된 스트림을 제공합니다.
         *
         * 3. average()를 호출하여 스트림의 요소들의 평균을 계산하고 OptionalDouble로 반환합니다.
         * 이는 평균값이 없을 경우(예: 스트림이 비어 있는 경우)를 대비하기 위함입니다.
         *
         * 4.getAsDouble()을 통해 OptionalDouble에서 실제 평균값을 추출합니다.
         * 만약 평균값이 존재하지 않을 경우(예: 스트림이 비어 있는 경우) 예외가 발생합니다.
         *
         */

        Stream<Member> stream1 = list.stream();

        System.out.println("나이만 출력합니다.");
        IntStream intStream = stream1.mapToInt(Member::getAge);
        intStream.forEach(age -> System.out.println(age));

        System.out.println("나이만 평균을 구합니다.");
        stream1 = list.stream();


        System.out.println("나이만 출력합니다.");
        IntStream intStream1 = stream1.mapToInt(Member::getAge);
        intStream1.forEach(age -> System.out.println(age));
        //위 문장을 이용해서 스트림을 사용하면 다음 문장에서 사용할 수 없습니다.

        System.out.println("나이의 평균을 구합니다.");
        stream1 = list.stream();
        intStream1 = stream1.mapToInt(Member::getAge);
        OptionalDouble optional = intStream1.average();

        if (optional.isPresent()) {
            Double avg = optional.getAsDouble();
            System.out.println(avg);
        } else {
            System.out.println("비어있어요");
        }
    }
}

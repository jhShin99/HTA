package ex21.ex21_stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExamCollection2 {
    public static void main(String[] args) {
        /**
         * 스트림 생성 방식
         * 1. 컬렉션
         * 2. 배열
         * 3. 특정 범위의 정수 이용
         * 4. 람다식
         */

        List<String> list = Arrays.asList("홍길동", "hta", "자바");
        //==========3-1. Stream 방식
        /**
         * 스트림 생성 방법 - 컬렉션
         * Stream<T> Collection.stream()
         * => Collection의 자식인 List와 Set을 구현한 컬렉션 클래스들은 모두 이 메서드로
         *    스트림을 생성할 수 있습니다.
         *
         * list.steram() 메서드는 리스트의 요소들을 스트림으로 변환합니다.
         * 스트림은 데이터를 일련의 연산으로 처리할 수 있는 추상화된 객체입니다.
         * 이 스트림은 리스트의 요소를 순차적으로 처리할 수 있게 해줍니다.
         */
        System.out.println("==========3-1. Stream 방식==========");
        Stream<String> stream = list.stream();
        stream.forEach(
                (name) -> {
                    System.out.println(name);
                }
        );

        //==========3-2. Stream 방식
        System.out.println("==========3-2. Stream 방식==========");
        Stream<String> stream2 = list.stream();
        stream2.forEach(name -> System.out.println(name));

        //========== 4. Stream 방식
        System.out.println("==========4. Stream 방식 ==========");
        Stream<String> stream3 = list.stream();
        stream3.forEach(System.out::println);

        //오류 발생 : stream has already been operated upon or closed
        //long count = stream3.count(); //스트림이 위에서 사용된 뒤라 다시 사용할 수 없습니다.

        System.out.println("========== collect(Collectors.toList())==========");
        Stream<String> stream4 = list.stream();
        //새로운 리스트에 결과를 저장합니다.
        List<String> list2 = stream4.sorted().collect(Collectors.toList());
        System.out.println(list2);

        Stream<String> stream5 = list.stream();
        Stream<String> list3 = stream5.sorted();

        list3.forEach(System.out::println);

        //내림차순 정렬
        List<String> sortedList = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sortedList); //[홍길동, 자바, hta]
    }
}

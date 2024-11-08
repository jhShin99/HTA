package ex21.ex21_stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 자바의 스트림(Stream)은 Java 8에서 도입된 기능으로,
 * 컬렉션(Collection)이나 배열(array)과 같은 데이터 소스를 일련의 연산을 통해 처리할 수 있도록 해주는 추상화된 도구입니다.
 *
 * 이를 통해 데이터를 필터링, 매핑, 정렬, 집계 등의 다양한 작업을 손쉽게 수행할 수 있습니다.
 *
 * 스트림의 특징
 * (1) 스트림은 데이터 소스를 변경하지 않습니다.
 *     스트림은 데이터 소스로 부터 데이터를 읽기만할 뿐 데이터 소스를 변경하지 않습니다.
 *
 *     예) 정렬된 결과를 새로운 컬렉션이나 배열에 담아서 반환할 수 있습니다.
 *         List<String> list = strStream2.sorted().collect(Collectors.toList());
 * (2) 스트림은 일회용입니다.
 *     스트림은 Iterator 처럼 일회용입니다. Iterator로 컬렉션의 요소를 모두 읽고 나면 다시 사용할 수 없습니다.
 *     필요하면 스트림을 다시 생성해야 합니다.
 *     예)
 *        stream3.forEach(System.out::println);
 *        int count = stream3.count(); //오류 발생
 *
 * (3) 스트림은 작업을 내부 반복으로 처리합니다.
 *     내부 반복이란 반복문을 메서드의 내부에 숨겼다는 것을 의미합니다.
 *     foEach()는 매개변수에 대입된 람다식을 데이터 소스의 모든 요소에 적용한다.
 *     예) stream3.forEach(System.out::println);
 *
 * (4) 중간 연산과 최종 연산 => 지연된 연산
 *     중간 연산 - 연산결과가 스트림인 연산. 반복적으로 적용가능
 *                예) filter() - 걸러내기, distinct() - 중복제거, sort() - 정렬, limit() - 스트림 자르기;
 *
 *     최종 연산 - 연산결과가 스트림이 아닌 연산. 스트림의 요소를 소모하므로 한번만 적용가능
 *                예) count() - 갯수, sum() - 합계, average() - 평균, forEach()
 *
 *     => 최종 연산이 수행되기 전까지는 중간 연산이 수행되지 않습니다.
 *        중간 연산을 호출하는 것은 단지 어떤 작업이 수행되어야 하는지를 지정해 주는 것일 뿐입니다.
 *
 * (5) Stream<Integer>와 IntStream
 *     Stream<T> 형식의 스트림은 데이터 소스가 기본형인 경우 오토박싱과 언박싱으로 인한 비효율을 줄이기 위해
 *     IntStream, LongStream, DoubleStream이 제공되고 있습니다.
 *     Stream<Integer> 대신 IntStream 사용하는 것이 효율적입니다.
 */
public class ExamCollection {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("홍길동", "hta", "자바");
        /**
         *Arrays.asList(...): java.util.Arrays 클래스의 정적 메서드로,
         * 여기서 반환되는 List는 고정 크기입니다.
         * list.add() 시 java.lang.UnsupportedOperationException 발생
         */

        //list.add("error");

        //========== 1. Iterator 방식
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
        linePrint();

        // ========== 2. get() 이용
        for (String name : list) {
            System.out.println(name);
        }
        linePrint();
    }

    private static void linePrint() {
        for (int i=0; i<50; i++)
            System.out.print("=");

        System.out.println();
    }
}

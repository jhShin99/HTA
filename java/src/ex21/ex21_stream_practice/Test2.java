package ex21.ex21_stream_practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("test2.java", "test.java", "test2.java", "test.txt");

        //[TEST.JAVA, TEST.TXT, TEST.TXT, TEST2.JAVA, TEST2.JAVA]
        List<String> result1 = myList.stream() //생성하기
                .filter(s -> s.indexOf(".") != -1) //조건에 따라 걸러내는 작업을 합니다.
                .map(String::toUpperCase) //대문자로 만들어요(특정 조건에 해당하는 값으로 만들어요)
                .sorted() // 정렬합니다.
                .collect(Collectors.toList()); // 최종결과를 리스트로 만듭니다.
        System.out.println(result1.toString());

        //[test.java, test.txt, test2.java]
        List<String> result2 = myList.stream() //생성하기
                .filter(s -> s.indexOf(".") != -1) //조건에 따라 걸러내는 작업을 합니다.
                .map(s -> s.toLowerCase()) // 소문자로 만들어요(특정 조건에 해당하는 값으로 만들어요)
                .distinct() //중복 제거
                .sorted() //정렬합니다.
                .collect(Collectors.toList()); //최종결과를 리스트로 만듭니다.
        System.out.println(result2.toString());
    }
}

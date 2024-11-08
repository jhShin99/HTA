package ex21.ex21_stream_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Exam1 {

    public static void main(String[] args) {
        List<Member> member = new ArrayList<>();
        member.add(new Member("홍길동", 21));
        member.add(new Member("자바", 30));
        member.add(new Member("이순신", 30));

        Stream<Member> stream = member.stream();
        stream.forEach(s -> {
            System.out.println(s);
        });

        Stream<Member> stream2 = member.stream();
        stream2.forEach(System.out::println);


    }
}

package test.d0830;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main1 {

    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        list.add(new Member("홍길동", 21));
        list.add(new Member("자바", 30));
        list.add(new Member("이순신",30 ));

    }
}

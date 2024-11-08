package ex15.ex15_treeset;

import java.util.TreeSet;

public class TreeSet3_Person0 {

    public static void main(String[] args) {
        /**
         * TreeSet은 내부적으로 객체들을 정렬하여 저장하기 위해 Comparable 인터페이스를 구현한 객체들을 필요로 합니다.
         */
        //컬렉션 생성
        TreeSet<Person0> treeSet = new TreeSet<Person0>();

        //객체 생성
        //cannot be cast to class java.lang.Comparable
        //treeset은 정렬을 필요로 하지만 정렬 기준을 모르겠다는 뜻
        treeSet.add(new Person0("홍길동", 30));
        treeSet.add(new Person0("자바", 26));
        treeSet.add(new Person0("스프링", 26));
        treeSet.add(new Person0("홍길동", 35));

        System.out.println(treeSet);
    }
}

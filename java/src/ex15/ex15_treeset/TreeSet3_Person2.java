package ex15.ex15_treeset;

import java.util.TreeSet;

public class TreeSet3_Person2 {

    public static void main(String[] args) {
        /**
         * TreeSet은 내부적으로 객체들을 정렬하여 저장하기 위해 Comparable 인터페이스를 구현한 객체들을 필요로 합니다.
         */
        //컬렉션 생성
        TreeSet<Person2> treeSet = new TreeSet<Person2>();

        //객체 생성
        //Comparable 구현
        treeSet.add(new Person2("홍길동", 30));
        treeSet.add(new Person2("자바", 26));
        treeSet.add(new Person2("스프링", 26));
        treeSet.add(new Person2("홍길동", 35));

        /**
         * 여기서 compareTo 메서드는 나이(age)를 기준으로 비교합니다.
         * 따라서 나이가 같은 객체들은 동등한 것으로 간주됩니다.
         * 하지만 TreeSet은 compareTo 메서드에서 0을 반환하는 객체들은 중복된 것으로 간주하여 하나만 저장합니다.
         *
         * => 이름도 비교하기 위한 수정해야 합니다.
         */
        System.out.println(treeSet);
    }
}

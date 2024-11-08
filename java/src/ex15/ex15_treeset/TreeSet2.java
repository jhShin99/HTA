package ex15.ex15_treeset;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet2 {
    /**
     * Comparator는 Java의 java.util 패키지에 포함된 인터페이스로, 객체의 순서를 정의하기 위해 사용됩니다.
     * 주로 컬렉션의 정렬을 위해 사용되며, 이를 통해 사용자 정의 정렬 기준을 지정할 수 있습니다.
     *
     * 메서드: int compareTo(T o);
     *        이 메서드는 현재 객체와 전달된 객체 o를 비교하여 음수, 0, 또는 양수를 반환합니다. 반환 값은 다음과 같은 의미를 갖습니다.
     *        음수: 현재 객체가 o보다 작다.
     *        0: 현재 객체가 o와 같다.
     *        양수: 현재 객체가 o보다 크다.
     */

    //내림차순으로 정렬합니다.
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>(Comparator.reverseOrder());
        int num;
        while (set.size() < 6) {
            num = (int)(Math.random() * 45 + 1);
            set.add(num);
        }
        System.out.println(set);
    }
}

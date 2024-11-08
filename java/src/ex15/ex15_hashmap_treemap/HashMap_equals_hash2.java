package ex15.ex15_hashmap_treemap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 사용자 정의 클래스 Student를 키로 점수를 저장하는 HashMap 사용방법을 보여줍니다.
 * 학번과 이름이 동일한 Student를 동등 키로 간주하기 위해
 * Student 클래스에는 hashCode()와 equals() 메서드가 재정의 해야 합니다.
 * 동일한 객체인지 판별법 :
 * hashCode()의 리턴값이 다르면 다른 키로 인식됩니다.
 * hashCode()의 리턴값이 같으면 equals() 메서드의 리턴값으로 판별합니다.
 * equals() 메서드의 리턴값이 true이면 같은 키로 인식하고 다르면 다른 키로 인식합니다.
 */
public class HashMap_equals_hash2 {

    public static void main(String[] args) {
        Map<Student2, Integer> map = new HashMap<Student2, Integer>();

        // new Student2(1. "홍길동") 이 다른 키로 인식해서 95저장후 195가 저장됩니다.
        Student2 s1 = new Student2(1, "홍길동");
        Student2 s2 = new Student2(1, "홍길동");

        map.put(s1, 95);
        map.put(s2, 195);

        System.out.println("총 Entry 수: " + map.size());

        //출력방법 - Iterator
        Set<Student2> s = map.keySet();
        Iterator<Student2> it = s.iterator();
        while (it.hasNext()) {
            Student2 key = it.next();
            System.out.println(key + ":" + map.get(key));
        }
    }
}


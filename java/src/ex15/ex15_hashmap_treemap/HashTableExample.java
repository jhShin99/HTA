package ex15.ex15_hashmap_treemap;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableExample {

    public static void main(String[] args) {
        Hashtable<String, String> ht = new Hashtable<String, String>();
        ht.put("사과", "Apple");
        ht.put("딸기", "StrawBerry");
        ht.put("포도", "Grapes");

        //해쉬 테이블의 값을 키를 이용하여 얻는다.
        String val = ht.get("포도");
        if (val != null) {
            System.out.println("포도 -> " + val);
        }

        Enumeration<String> Enum = ht.keys(); //해쉬 테이블의 키 요소들에 대한 Enumeration 객체 반환
        while (Enum.hasMoreElements()) {
            String k = Enum.nextElement(); // Generic을 사용해서 아래와 같이 사용 안해도 된다.
            // String k = (String)Enum.nextElement();

            String v = ht.get(k); // 제네릭을 사용해서 아래와 같이 사용 안해도 된다.
            //String v = (String) ht.get(k);
        }
    }
}

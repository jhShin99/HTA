package ex15.ex15_hashmap_treemap;

import java.util.TreeMap;

public class TreeMap_Generics {

    public static void main(String[] args) {
        // 방법1. 업캐스팅
        // Map<String, String> tm = new TreeMap<String, String>();

        // 방법2. 구현 클래스를 통한 객체 생성
        TreeMap<String, String> tm = new TreeMap<>();

        //Key와 Value 쌍을 삽입
        //Map 메서드는 put을 이용해 (Key, Value) 쌍으로 자료 저장합니다.
        tm.put("woman", "재미있니");
        tm.put("man", "좋은하루");
        tm.put("age", new String("10"));
        tm.put("city", "seoul");
        tm.put("city", "Busan");
        System.out.println(tm);
    }
}

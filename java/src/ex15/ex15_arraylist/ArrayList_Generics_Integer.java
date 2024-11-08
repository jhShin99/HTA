package ex15.ex15_arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList_Generics_Integer {

    public static void main(String[] args) {
        //ArrayList 객체 생성
        ArrayList<Integer> list = new ArrayList<Integer>();

        //list에 3개의 데이터를 추가
        list.add(1); //list.add(Integer.valueOf(1)); 오토 박싱
        list.add(2);
        list.add(3);

        int length = list.size(); //list에 있는 데이터의 수를 구하는 메서드

        // 출력 방법 1. - 해당 객체명으로 출력하는 방법
        System.out.println("===객체명으로 출력하기===");
        System.out.println(list);
        System.out.println(list.toString());

        // 출력 방법 2. - get() 메서드 이용법1
        System.out.println("===== get()로 출력 =====");
        for (int cnt = 0; cnt < length; cnt++) {
            // get(index) 메서드를 사용하여 index 위치에 있는 자료를 가져옵니다.
            // int num = list.get(cnt).intValue(); 오토 언박싱
            int num = list.get(cnt);
            System.out.println(num);
        }

        // 출력 방법 3. - for 문 사용 (코드 간결)
        System.out.println("===== 향상된 for 문 =====");
        for (int num : list) {
            System.out.println(num);
        }

        // 출력 방법 4. - Iterator 인터페이스 사용 : 반복자(요소를 순차적으로 접근하는 방식을 명시적으로 제어하는 경우 적합)
        System.out.println("=== Iterator 인터페이스 사용 ===");

        Iterator<Integer> elements = list.iterator();
        while (elements.hasNext()) {
            System.out.println(elements.next());
        }
    }
}

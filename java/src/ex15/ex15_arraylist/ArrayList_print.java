package ex15.ex15_arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList_print {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("하나");
        list.add(2);
        list.add(false);
        list.add("넷");
        list.add("five");
        list.add('A');

        // 출력 방법 1. - 해당 객체명으로 출력하는 방법
        System.out.println("===객체명으로 출력하기===");
        System.out.println(list);
        System.out.println(list.toString());

        // 출력 방법 2. - get() 메서드 이용법
        System.out.println("=== get() 메서드 이용법 ===");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + "번째 요소 = " + list.get(i));
        }

        System.out.println("=========================");

        for (int i = 0; i < list.size(); i++) {
            Object s = list.get(i); //get() 메서드의 반환형은 Object형
            System.out.println(s);
        }

        // 출력 방법 3. - for문 사용 (코드 간결)
        System.out.println("==== 향상된 for문 사용 ====");
        for (Object a : list) {
            System.out.println(a);
        }

        // 출력 방법 4. - Iterator 인터페이스 사용 : 반복자(요소를 순차적으로 접근하는 방식을 명시적으로 제어하는 경우 적합)
        System.out.println("=== Iterator 인터페이스 사용 ===");
        Iterator elements = list.iterator();
        // hasNext() : 읽어올 요소가 있는지 확인합니다.
        while (elements.hasNext()) {
            //next() 메서드를 이용해서 차례대로 한개씩 데이터 가져옵니다.
            System.out.println(elements.next());
        }
    }
}

package ex15.ex15_generic_method_box;

import java.util.ArrayList;
import java.util.List;

public class WildTest {
    /**
     * 와일드 카드(?)
     * 제네릭 타입을 매개값이나 리턴 타입으로 사용할 때 구체적인 타입 대신 와일드 카드를 사용할 수 있습니다.
     * <?> => 타입 파라미터를 대치하는 구체적인 타입으로 모든 클래스나 인터페이스 타입이 올 수 있습니다.
     *     => <? extends Object> 줄임 표현, Unbounded WildCard라고 합니다.
     * <? extends 상위타입> => 타입 파라미터를 대치하는 구체적인 타입으로 특정 클래스와 특정 클래스를 상속받은 클래스로 제한합니다.
     * <? super 하위타입> => 타입 파라미터를 대치하는 구체적인 타입으로 특정 클래스와 그 클래스의 상위 클래스로만 제한합니다.
     */
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");

        //Integer 자료형 list2 객체 생성
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(Integer.valueOf(3));

        //Double형 list3 생성
        ArrayList<Double> list3 = new ArrayList<>();
        list3.add(10.1);
        list3.add(11.2);
        list3.add(12.3);

        //List는 인터페이스이기 때문에 ArrayList 생성 후 Upcasting 이용
        //static 메서드 호출
        printData(list);
        printData(list2);
        printData(list3);

    }

    //리스트 출력 메서드
    // public static void printData(List<Object> list) { // Integer가 Object로 변환되지 않습니다.
                                                         // 반드시 타입 파라미터가 일치해야 합니다.
    private static void printData(List<?> list) {
        for (Object v : list) {
            System.out.println(v);
        }
    }
}

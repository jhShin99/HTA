package ex15.ex15_arraylist;

import java.util.ArrayList;

public class ArrayTest_contains2 {

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>(10);
        list1.add("봄");
        list1.add("여름");

        ArrayList<String> list2 = new ArrayList<String>(10);
        list2.add("봄");
        list2.add("봄");
        list2.add("여름");
        list2.add("가을");
        list2.add("겨울");

        System.out.println(list1);
        System.out.println(list2);
        System.out.println("========================");
        for (int i = 0; i<list2.size(); i++) {
            list2.remove(i); // 삭제하면서 index 위치가 변한다. 그러므로 이렇게 하면 원하는대로 지워지지 않는다.
            System.out.println(list2);
        }
        System.out.println("========== 삭제 후 ==========");
        System.out.println(list1);
        System.out.println(list2);
    }
}

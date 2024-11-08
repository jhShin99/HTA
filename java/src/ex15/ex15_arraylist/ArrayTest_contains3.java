package ex15.ex15_arraylist;

import java.util.ArrayList;

public class ArrayTest_contains3 {

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
        for (int i = list2.size() - 1; i >= 0; i--) {
            if (list1.contains(list2.get(i))) {
                list2.remove(i);
            }
        }
        System.out.println(list1);
        System.out.println(list2);
    }
}

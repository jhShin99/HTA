package ex15.ex15_arraylist;

import java.util.ArrayList;

public class ArrayTest_retainAll {

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("봄");
        list1.add("여름");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("봄");
        list2.add("봄");
        list2.add("여름");
        list2.add("가을");
        list2.add("겨울");

        //list2에서 list1과 같은 데이테만 남깁니다.
        //list2 교집합 list1 (교집합)
        list2.retainAll(list1);

        System.out.println(list1); //[봄, 여름]
        System.out.println(list2); //[봄]


    }
}

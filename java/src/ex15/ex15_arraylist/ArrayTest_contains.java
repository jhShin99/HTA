package ex15.ex15_arraylist;

import java.util.ArrayList;

public class ArrayTest_contains {

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("봄");
        list1.add("여름");

        if (list1.contains("봄")) {
            System.out.println("봄이 존재합니다.");
        } else {
            System.out.println("봄이 존재하지 않습니다.");
        }
    }
}

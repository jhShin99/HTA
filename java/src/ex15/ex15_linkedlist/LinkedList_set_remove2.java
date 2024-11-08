package ex15.ex15_linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedList_set_remove2 {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("포도");
        list.add("딸기");
        list.add("복숭아");
        list.add(2, "키위");
        pLinkedList(list);

        list.set(0, "오렌지");
        pLinkedList(list);

        list.remove(1);
        pLinkedList(list);

        list.remove("키위");
        pLinkedList(list);
    }

    private static void pLinkedList(LinkedList<String> list) {
        System.out.println("=====================");
        int length = list.size();
        for (int cnt = 0; cnt < length; cnt++) {
            String str = list.get(cnt);
            System.out.println("index=" + cnt + "\t데이터=" + str);
        }
    }
}

package ex15.ex15_treeset;

import java.util.TreeSet;

public class TreeSet1 {

    public static void main(String[] args) {
        // 저장할 때 이미 정렬하기 때문에 읽어올 때 따로 정렬할 필요가 없습니다.
        TreeSet<Integer> set = new TreeSet<Integer>();
        int num;
        while (set.size() < 6) {
            num = (int)(Math.random() * 45 + 1);
            set.add(num);
        }
        System.out.println(set);
    }
}

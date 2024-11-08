package ex15.ex15_arraylist;

import java.util.ArrayList;

public class ArrayList_add_set_remove {
    public static void main(String[] args) {
        //ArrayList 객체 생성
        ArrayList<String> list = new ArrayList<String>();

        //list에 3개의 데이터를 추가
        list.add("포도");
        list.add("딸기");
        list.add("복숭아");
        pArrayList(list);

        // list에 2개의 데이터를 삽입
        list.add(2, "키위"); //인덱스 2 위치에 삽입
        pArrayList(list);

        list.add(4, "키위"); // 인덱스 4 위치에 삽입
        pArrayList(list);

        // 인덱스 0 위치에 데이터를 "오렌지"로 바꿉니다.
        list.set(0, "오렌지");
        pArrayList(list);

        // 인덱스 1 위치에 있는 데이터를 삭제합니다.
        list.remove(1);
        pArrayList(list);

        //list에서 "키위"라는 데이터를 찾아서 삭제합니다.
        list.remove("키위");
        pArrayList(list);
    }

    private static void pArrayList(ArrayList<String> list) {
        System.out.println("=====================");
        int length = list.size();
        for (int cnt = 0; cnt < length; cnt++) {
            String str = list.get(cnt);
            System.out.println("index=" + cnt + "\t데이터=" + str);
        }
    }
}

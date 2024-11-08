package ex15.ex15_arraylist;

import java.util.ArrayList;

public class ArrayList_Generics_String {

    public static void main(String[] args) {
        // ArrayList 객체 생성
        ArrayList<String> list = new ArrayList<>();

        // list에 3개의 데이터를 추가
        list.add("포도");
        list.add("딸기");
        list.add("복숭아");

        int num = list.size(); // list에 있는 데이터의 수를 구하는 메서드

        // list에 있는 데이터의 수만큼 반복하면서 데이터를 가져와 출력
        for (int cnt = 0; cnt < num; cnt++) {
            // get(index) 메서드를 사용하여 index 위치에 있는 자료를 가져옵니다.
            String str = list.get(cnt);
            System.out.println(str);
        }

        System.out.println("===== 향상된 for 문 =====");
        for (String str : list)
            System.out.println(str);
    }
}

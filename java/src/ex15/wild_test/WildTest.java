package ex15.wild_test;

import java.util.ArrayList;
import java.util.List;

public class WildTest {

    public static void main(String[] args) {
        ArrayList<Child> listc = new ArrayList<>();
        listc.add(new Child("손자1"));
        listc.add(new Child("손자2"));
        print(listc);

        ArrayList<Parent> listp = new ArrayList<>();
        listp.add(new Parent("큰아버지"));
        listp.add(new Parent("작은아버지"));
        print(listp);

        ArrayList<GrandParent> listg = new ArrayList<>();
        listg.add(new GrandParent("할아버지"));
        print(listg);

    }

    // GrandParent 클래스와 GrandParent 클래스의 하위 클래스로 생성된 인스턴스만 매개변수로 전달 가능합니다.
    private static void print(List<? extends GrandParent> list) {
        for (Object v : list) {
            System.out.println(v);
        }
    }

    // Child 클래스와 Child 클래스의 상위 클래스로 생성된 인스턴스만 매개변수로 전달 가능합니다.
    private static void print2(List<? super Child> list) {
        for (Object v : list) {
            System.out.println(v);
        }
    }
}

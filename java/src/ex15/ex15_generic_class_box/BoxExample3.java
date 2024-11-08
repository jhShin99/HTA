package ex15.ex15_generic_class_box;

public class BoxExample3 {

    public static void main(String[] args) {
        Box3<Integer, String> box = new Box3<Integer, String>();
        box.setKey(1);
        box.setValue("홍길동");
        System.out.println(box);

        Box3<Integer, String> box2 = new Box3<>(); //자바 7버전부터 사용가능
        box2.setKey(2);
        box2.setValue("이순신");
        System.out.println(box2);
    }
}

package ex15.ex15_generic_method_box;

public class BoxExample2 {

    public static void main(String[] args) {

        Box2<Integer, String> box = Util2.<Integer, String> boxing(1, "홍길동");
        System.out.println(box);
    }
}

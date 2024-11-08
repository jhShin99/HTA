package ex15.ex15_generic_class_box;

public class BoxExample2 {

    public static void main(String[] args) {
        Box2<Integer> box = new Box2<>();
        Box2<String> box2 = new Box2<>();

        box.set(1);                //int -> Integer (오토 박싱)
        Integer num = box.get();   //Integer -> int (오토 언박싱)
        System.out.println(num);

        box2.set("사과");
        String fruit = box2.get();
        System.out.println(fruit);

    }
}

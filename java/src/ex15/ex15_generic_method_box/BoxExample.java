package ex15.ex15_generic_method_box;

public class BoxExample {
    public static void main(String[] args) {
        Box<Character> box = Util.boxing('a');
        char test = box.get();
        System.out.println(test);

        Box<Integer> box1 = Util.<Integer>boxing(100);
        int intValue = box1.get();

        System.out.println(intValue);

        Box<String> box2 = Util.<String>boxing("홍길동");
        String name = box2.get();

        System.out.println(name);
    }
}

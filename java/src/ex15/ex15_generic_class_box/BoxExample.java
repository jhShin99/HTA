package ex15.ex15_generic_class_box;

public class BoxExample {

    //제네릭이 나온 이유. 일일이 형변환 하기 힘들다
    public static void main(String[] args) {
        Box box = new Box();
        box.set("홍길동");
        String name = (String) box.get();
        System.out.println(name);

        Box box2 = new Box();
        box2.set(100);
        int age = (int) box2.get();
        System.out.println(age);
    }
}

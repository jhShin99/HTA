package ex13.ex13_object_tostring;

public class ObjectExample {
    public static void main(String[] args) {
        Circle obj1 = new Circle(5);
        Circle obj2 = new Circle(15);

        System.out.println(obj1.toString());
        System.out.println(obj1);

        System.out.println(obj2.toString());
        System.out.println(obj2);
    }
}

package ex13.ex13_object_hashcode;

public class ObjectExample2 {

    public static void main(String[] args) {
        Circle c1 = new Circle(5);
        Circle c2 = new Circle(5);



        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
    }
}

package ex13.ex13_object;

public class ObjectExample2 {

    public static void main(String[] args) {
        Circle obj1 = new Circle(5);
        Circle obj2 = new Circle(5);

        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());

        System.out.println(obj1.toString());
        //System.out.print()나 System.out.println() 메서드에
        //객체를 넘겨주면 toString() 메서드가 호출됩니다.
        System.out.println(obj1);

        System.out.println(obj2.toString());
        System.out.println(obj2);


    }
}

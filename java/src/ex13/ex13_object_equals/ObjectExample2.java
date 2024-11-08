package ex13.ex13_object_equals;

import ex10.ex10_geometry_common.Polygon;

public class ObjectExample2 {

    public static void main(String[] args) {
        Circle obj1 = new Circle(5);
        Circle obj2 = new Circle(5);

        System.out.println(obj1);
        System.out.println(obj1.toString());

        System.out.println(obj2);
        System.out.println(obj2.toString());

        if (obj1.equals(obj2))
            System.out.println("obj1.equals(obj2) : 같음");
        else
            System.out.println("obj1.equals(obj2) : 다름");

        if (obj1 == obj2)
            System.out.println("obj1 == obj2 : 같음");
        else
            System.out.println("obj1 == obj2 : 다름");


    }




}

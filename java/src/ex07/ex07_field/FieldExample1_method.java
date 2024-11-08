package ex07.ex07_field;

import java.util.Scanner;

public class FieldExample1_method{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("반지름을 입력하세요> ");
        double radius = sc.nextDouble();
        Circle obj = new Circle(radius);
        print(obj);
        obj.radius = 5.5;
        print(obj);
    }

    public static void print(Circle circle) {
        System.out.println("원의 반지름 = " + circle.radius);
        System.out.println("원의 넓이 = " + circle.getArea());
    }
}

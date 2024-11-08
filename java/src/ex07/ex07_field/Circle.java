package ex07.ex07_field;

public class Circle {

    double radius;

    final double PI = 3.14;

    public Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return radius * radius * PI;
    }
}

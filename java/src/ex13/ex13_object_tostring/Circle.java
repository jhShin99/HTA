package ex13.ex13_object_tostring;

public class Circle {

    int radius; // 반지름
    public Circle(int radius) {
        this.radius = radius;
    }

    public String toString() {
        return "radius=" + radius;
    }

}

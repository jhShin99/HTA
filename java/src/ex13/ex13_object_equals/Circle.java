package ex13.ex13_object_equals;

public class Circle {

    int radius;
    Circle(int radius) {
        this.radius = radius;
    }

    public String toString() {
        return "radius=" + radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Circle) {
            Circle obj2 = (Circle) obj; 
            return this.radius == obj2.radius;
        } else {
            return false;
        }
    }
}

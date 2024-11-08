package ex08.ex08_interface_extends;

public class InterfaceExample {

    public static void main(String[] args) {
        Rectangle obj = new Rectangle(100, 200, 10, 10);
        printRectangle(obj);

        obj.moveTo(25,35);
        printRectangle(obj);

        obj.moveBy(-5, -5);
        printRectangle(obj);

        obj.resize(30,30);
        printRectangle(obj);
    }

    static void printRectangle(Rectangle obj) {
        System.out.printf("사각형: 위치(%3d, %3d) 크기(%3d x %3d) %n", obj.x, obj.y, obj.width, obj.height);
    }
}

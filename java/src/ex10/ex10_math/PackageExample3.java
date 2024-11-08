package ex10.ex10_math;

public class PackageExample3 {

    public static void main(String[] args) {
        ex10.ex10_geometry_polygon.Rectangle obj = new ex10.ex10_geometry_polygon.Rectangle(2, 3);
        System.out.println("가로 = " + obj.width);
        System.out.println("높이 = " + obj.height);
        System.out.println("면적 = " + obj.getArea());
    }
}

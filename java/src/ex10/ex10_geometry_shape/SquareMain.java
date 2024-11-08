package ex10.ex10_geometry_shape;

public class SquareMain {

    public static void main(String[] args) {
        Square obj = new Square(100, 200, 15);
        for (int i=0; i< obj.x.length; i++) {
            System.out.printf("X[%d]=%d, Y[%d]=%d", i, obj.x[i], i, obj.getY(i));
            System.out.println();
        }
        for (int i=0; i < obj.x.length; i++) {
            System.out.printf("(%d, %d)", obj.x[i], obj.getY(i));
            System.out.println();
        }
    }
}

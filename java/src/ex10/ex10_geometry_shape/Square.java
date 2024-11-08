package ex10.ex10_geometry_shape;

import ex10.ex10_geometry_common.Polygon;

public class Square extends Polygon {

    public Square(int x, int y, int sideLength) {
        super(4);
        setPoint(0, x, y);
        setPoint(1, x + sideLength, y);
        setPoint(2, x + sideLength, y + sideLength);
        setPoint(3, x, y + sideLength);

    }

    public int getX(int idx) {
        return x[idx];
    }

    public int getY(int idx) {
        return y[idx];
    }
}


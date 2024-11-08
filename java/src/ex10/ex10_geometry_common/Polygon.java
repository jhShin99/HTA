package ex10.ex10_geometry_common;

public class Polygon {
    public int[] x;
    protected int[] y;

    protected Polygon(int idx) {
        x = new int[idx];
        y = new int[idx];
    }

    protected void setPoint(int index, int x, int y) {
        this.x[index] = x;
        this.y[index] = y;
    }

}

package ex08.ex08_interface_extends;

public class Rectangle implements Transformable {
    int x;
    int y;
    int width;
    int height;

    Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveBy(int xOffset, int yOffset) {
        this.x = x + xOffset;
        this.y = y + yOffset;
    }

    @Override
    public void resize(int width, int height) {
        this.width = width;
        this.height = height;
    }
}

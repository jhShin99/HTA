package ex08.ex08_multiple_inheritance;

public class Lable implements Changeable{

    String text, foreground, background, font;
    int width, height;

    Lable(String text, int width, int height, String foreground, String background, String font) {
        this.text = text;
        this.width = width;
        this.height = height;
        this.foreground = foreground;
        this.background = background;
        this.font = font;
    }
    @Override
    public void resize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void setForeground(String color) {
        this.foreground = color;
    }

    @Override
    public void setBackground(String color) {
        this.background = color;
    }

    @Override
    public void setFont(String font) {
        this.font = font;
    }

}

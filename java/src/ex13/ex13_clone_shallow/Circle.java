package ex13.ex13_clone_shallow;

public class Circle implements Cloneable{

    Point p;
    double r;

    public Circle(Point p, double r) {
        this.p = p;
        this.r = r;
    }

    @Override
    public Object clone() { // 반환형이 Object형 입니다.
        try {
            // 슈퍼 클래스의 clone 메서드를 호출해서 그 결과를 리턴
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("복제 오류 발생했습니다.");
            return null;
        }
    }

    public String toString() {
        return "[p=" + p + ", r=" + r + "]";
    }
}
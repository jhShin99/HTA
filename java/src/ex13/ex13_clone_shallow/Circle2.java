package ex13.ex13_clone_shallow;

public class Circle2 implements Cloneable{

    Point p;
    double r;

    public Circle2(Point p, double r) {
        this.p = p;
        this.r = r;
    }

    /**
     * Object 클래스에 정의된 clone()
     * protected Object clone() throws CloneNotSupportedException;
     * ==> 오버라이딩시 접근 제어자 변경
     * (protected => public : 상속관계 없이 다른 클래스에서 호출 할 수 있습니다.
     */

    public Circle2 clone() {
        try {
            return (Circle2) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("복제 오류 발생했습니다.");
            return null;
        }
    }

    public String toString() {
        return "[p=" + p + ", r=" + r + "]";
    }
}
package ex07.ex07_static_field;

public class Test2 {

    public static void main(String[] args) {
        System.out.println("정적 변수 grandTotal = " + Accumulator.grandTotal);
        Accumulator obj1 = new Accumulator();
        obj1.accumulate(10);
        System.out.println("obj1.total = " + obj1.total);
        System.out.println("obj1.grandTotal = " + obj1.grandTotal);
        System.out.println("Accumulator.grandTotal = " + Accumulator.grandTotal);
        System.out.println("===========================");
        Accumulator obj2 = new Accumulator();
        obj2.accumulate(20);
        System.out.println("obj2.total = " + obj2.total);
        System.out.println("obj2.grandTotal = " + obj2.grandTotal);
        System.out.println("Accumulator.grandTotal = " + Accumulator.grandTotal);
    }
}

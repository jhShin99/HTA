package ex07.ex07_static_method;

import ex07.ex07_static_field.Accumulator;

public class StaticMethodExample2 {

    public static void main(String[] args) {
        int grandTotal = Accumulator.getGrandTotal();
        System.out.println("총계 = " + grandTotal);
        Accumulator obj1 = new Accumulator();
        Accumulator obj2 = new Accumulator();
        obj1.accumulate(10);
        obj2.accumulate(20);

        grandTotal = Accumulator.getGrandTotal();

        StaticMethodExample2 staticMethodExample2 = new StaticMethodExample2();
        staticMethodExample2.print(obj1);
        staticMethodExample2.print(obj2);
        System.out.println("총계 = " + grandTotal);
    }

    void print(Accumulator a) {
        System.out.println("total = " + a.total);
    }
}

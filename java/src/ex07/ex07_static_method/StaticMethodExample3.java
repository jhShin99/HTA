package ex07.ex07_static_method;

import ex07.ex07_static_field.Accumulator;

public class StaticMethodExample3 {

    public static void main(String[] args) {
        int grandTotal = Accumulator.getGrandTotal();
        System.out.println("총계 = " + grandTotal);
        Accumulator obj1 = new Accumulator();
        Accumulator obj2 = new Accumulator();
        obj1.accumulate(10);
        obj2.accumulate(20);

        grandTotal = Accumulator.getGrandTotal();

        StaticMethodExample3 s = new StaticMethodExample3();
        s.print(obj1);
        s.print(obj2);
        System.out.println("총계 = " + grandTotal );
    }

    void print(Accumulator a) {
        System.out.println("total = " + a.total);
    }
}

package ex07.ex07_static_final;

public class StaticFieldExample2 {

    public static void main(String[] args) {
        System.out.println("상한값 = " + LimitedValue.UPPER_LIMIT);

        LimitedValue v = new LimitedValue();

        v.setValue(200);
        System.out.println("v.value = " + v.value);

        v.setValue(200000);
        System.out.println("v.value = " + v.value);
    }
}

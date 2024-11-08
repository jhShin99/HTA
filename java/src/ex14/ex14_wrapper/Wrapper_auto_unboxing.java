package ex14.ex14_wrapper;

public class Wrapper_auto_unboxing {

    public static void main(String[] args) {
        Integer obj = Integer.valueOf("10");
        int sum = obj + 20;
        System.out.println(sum);

        String a = obj + "" + 20;
        System.out.println(a);

        String b = obj.toString() + 20;
        System.out.println(b);
    }
}

package ex14.ex14_wrapper;

public class Wrapper_auto_boxing {

    public static void main(String[] args) {
        printDouble(123.45);
    }


    static void printDouble(Double obj) {
        System.out.println("obj.doubleValue() = " + obj.doubleValue());
        System.out.println("obj.toString() = " + obj.toString());
    }
}

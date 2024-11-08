package ex07.ex07_private_field;

public class MethodExample2 {

    public static void main(String[] args) {
        Numbers obj = new Numbers(new int[]{10, 20, 30, 40, 50});
        print(obj);
    }

    static void print(Numbers obj) {
        System.out.println("합계 = " + obj.getTotal());
        System.out.println("평균 = " + obj.getAverage());
    }
}

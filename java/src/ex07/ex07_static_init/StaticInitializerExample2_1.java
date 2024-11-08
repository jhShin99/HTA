package ex07.ex07_static_init;

public class StaticInitializerExample2_1 {

    public static void main(String[] args) {
        System.out.println("main 실행시작");

        System.out.println(HundredNumbers.arr[35]);
        System.out.println(HundredNumbers.arr[27]);
        System.out.println(HundredNumbers.arr[63]);

        HundredNumbers2 h = new HundredNumbers2();
        HundredNumbers2 h2 = new HundredNumbers2();
    }
}

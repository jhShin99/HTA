package ex07.ex07_static_init;

public class StaticInitializerExample3 {

    public static void main(String[] args) {
        System.out.println("main 실행시작");

        HundredNumbers3 h = new HundredNumbers3("호호");
        System.out.println(h.a);
    }
}

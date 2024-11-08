package ex21.ex21_ramda_method;

public class RamdaExampleSample {

    public static void main(String[] args) {
        write(a -> System.out.println(a));
        write(System.out::println);
    }

    static void write(Sample sample) {
        sample.print("오늘은 기다리던 금요일~ 좋아요");
    }
}

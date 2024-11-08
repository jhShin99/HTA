package ex21.ex21_ramda;

public class RamdaExampleSampleNegative {

    public static void main(String[] args) {
        //인터페이스 익명 구현 객체
        write(new Sample() {
            @Override
            public void print() {
                System.out.println("new Sample - 1");
            }
        });

        //람다식으로 변경
        write(() ->{
            System.out.println("new Sample - 2");
        });

        //실행문이 하나 있는 경우 중괄호를 생략하면 세미콜론을 생략합니다.
        write(() -> System.out.println("new Sample - 3"));
    }

    static void write(Sample sample) {
        sample.print();
    }
}

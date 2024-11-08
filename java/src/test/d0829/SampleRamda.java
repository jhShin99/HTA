package test.d0829;

public class SampleRamda {

    public static void main(String[] args) {

        //인터페이스 익명 구현 객체 방법
        int max = getMax(new Sample2() {
            @Override
            public int max(int a, int b) {
                return (a > b) ? a : b;
            }
        });
        System.out.println(max);

        //람다식
        max = getMax(
                (a, b) -> {
                    return (a > b) ? a : b;
                }
        );
        System.out.println(max);

        //실행문이 하나 있는 경우 중괄호를 생략하면 세미콜론을 생략합니다.
        max = getMax(
                (a, b) -> (a > b) ? a : b
        );
        System.out.println(max);
    }

    static int getMax(Sample2 sample) {
        return sample.max(100, 20);
    }
}

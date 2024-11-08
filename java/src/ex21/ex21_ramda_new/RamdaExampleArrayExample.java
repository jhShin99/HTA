package ex21.ex21_ramda_new;

public class RamdaExampleArrayExample {

    public static void main(String[] args) {
        ArrayExample a;

        //인터페이스 익명 구현 객체
        a = new ArrayExample() {
            @Override
            public int[] toArray(int size) {
                return new int[size];
            }
        };
        System.out.println(a.toArray(3).length);

        a = (int size) -> {
            return new int[size];
        };
        System.out.println(a.toArray(5).length);

        //방법 3.
        //매개변수가 하나 있다면 괄호를 생략할 수 있지만 매개 변수가 없으면 괄호가 꼭 있어야 합니다.
        a = size -> {
            return new int[size];
        };
        System.out.println(a.toArray(9).length);

        //방법 4.
        //실행문이 하나 있다면 중괄호 생략할 수 있습니다.
        //단, 실행문이 하나의 return문이라면 return 키워드도 생략해야 합니다.
        a = size -> new int[size];
        System.out.println(a.toArray(10).length);

        //방법 5.
        // 4번을 아래와 같이 나타냅니다.
        a = int[]::new;
        System.out.println(a.toArray(20).length);
    }
}

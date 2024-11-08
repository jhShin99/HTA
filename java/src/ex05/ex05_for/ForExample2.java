package ex05.ex05_for;

public class ForExample2 {

    public static void main(String[] args) {
        int cnt = 0;

        //초기식과 증감식 생략 가능합니다.
        for ( ; cnt < 10; ) {
            System.out.println(cnt);
            cnt++;
        }

        for (int a=1, b=5; a < b; a++, b--) {
            System.out.println("a = " + a + ", b = " + b);
        }
        System.out.println("끝.");
    }
}

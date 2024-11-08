package ex05.ex05_for;

public class Practice {

    public static void main(String[] args) {
        System.out.println("1~10까지 홀수 출력하기");
        for (int i = 1; i < 10; i+=2) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("1~10까지 짝수 출력하기");
        for (int i = 2; i <= 10; i+=2) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("1~10까지의 합 구하기 ");
        int sum=0;
        for (int i=1; i<=10; i++) {
            sum +=i;
        }
        System.out.println(sum);
        System.out.println("1~10까지 홀수의 합 구하기");
        sum=0;
        for (int i=1; i<10; i+=2) {
            sum+=i;
        }
        System.out.println(sum);
        System.out.println("1~10까지 짝수의 합 구하기");
        sum=0;
        for (int i=0; i<=10; i+=2) {
            sum+=i;
        }
        System.out.println(sum);
    }
}

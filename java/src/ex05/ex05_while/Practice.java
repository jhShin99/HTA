package ex05.ex05_while;

public class Practice {

    public static void main(String[] args) {
        int i = 1;

        System.out.println("1~10까지의 홀수 출력하기");
        while (i<=10) {
            System.out.println(i);
            i+=2;

        }
        i=0;

        System.out.println("1~10까지 짝수 출력하기");
        while (i<10) {
            i+=2;
            System.out.println(i);
        }
        i=1;

        System.out.println("1~10까지의 합 구하기");
        int sum = 0;
        while (i<=10) {
            sum += i;
            i++;
        }
        System.out.println(sum);
        i=1; sum=0;

        System.out.println("1~10까지의 홀수 합 구하기");
        while (i<=10) {
            sum += i;
            i+=2;
        }
        System.out.println(sum);
        i=0; sum=0;

        System.out.println("1~10까지의 짝수 합 구하기");
        while (i<10) {
            i+=2;
            sum+=i;
        }
        System.out.println(sum);

    }
}

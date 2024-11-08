package ex11.ex11_random;

import java.util.Random;

public class RandomExample1 {

    public static void main(String[] args) {
        Random random = new Random();

        // 0부터 100미만의 정수형 난수 발생 - 즉, 0부터 99까지의 정수형 난수 발생
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));

        //1부터 45까지의 난수 발생
        System.out.println("1~45까지의 난수 발생 : " + (random.nextInt(45)+1));

        for (int i = 0; i < 6; i++) {
            System.out.print((random.nextInt(45)+1) + "\t");
        }
    }
}

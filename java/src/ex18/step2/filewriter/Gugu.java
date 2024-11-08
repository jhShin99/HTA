package ex18.step2.filewriter;

public class Gugu {

    public static void main(String[] args) {


        for (int i = 2; i < 10; i++) {
            System.out.printf("[%d단]\t", i);
        }
        System.out.println();
        for (int i = 1; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%d\t", j, i, i * j);
            }
            System.out.println();
        }

    }
}

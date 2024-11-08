package ex05.ex05_if;

public class IfExample3_1 {
    public static void main(String[] args) {
        int num1 = 52;
        int num2 = 24;
        int num3 = 32;

        if (num1 > num2) {
            if (num1 > num3)
                System.out.println("num1이 제일 큽니다.");
        }

        //위 문장을 한 개의 if문과 &&연산자로 바꾸어 주세요.
        if (num1 > num2 && num1 > num3)
            System.out.println("num1이 제일 큽니다.");
    }
}

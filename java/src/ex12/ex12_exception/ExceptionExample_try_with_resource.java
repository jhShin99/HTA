package ex12.ex12_exception;

import java.io.FileReader;
import java.io.IOException;

public class ExceptionExample_try_with_resource {

    public static void main(String[] args) {
        try (FileReader reader = new FileReader("some.txt")) {
            System.out.println("try문 안입니다.");
        }
        //FileNotFoundException은 IOException의 서브클래스로
        //FileNotFoundException도 잡을 수 있습니다.
        catch (IOException e) {
            System.out.println("입출력 에러가 발생했습니다.");
        }
    }
}

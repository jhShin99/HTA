package ex12.ex12_exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionExample {
    //익셉션 파라미터의 다형성을 보여주는 예
    //익셉션을 처리하지 않아서 컴파일 오류 발생했습니다.
    public static void main(String[] args) {
        FileReader reader = null;
        try {
             reader = new FileReader("some.txt");
        } catch (IOException e) {
            System.out.println("입출력 오류 입니다.");
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

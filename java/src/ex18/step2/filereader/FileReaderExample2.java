package ex18.step2.filereader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample2 {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = null;
        char[] arr = new char[64];
        try {
            reader = new FileReader("poem.txt");

            while (true) {
                //Returns: The number of characters read
                // arr의 배열 크기 만큼 문자를 읽어 arr에 저장한 후 읽은 개수를 반환합니다.
                int num = reader.read(arr);
                if (num == -1) // 더 이상 읽을 데이터가 없는 경우
                    break;
                for (int cnt = 0; cnt < num; cnt++) {
                    System.out.printf("%c", arr[cnt]);
                }
            }
        } catch (FileNotFoundException f) {
            System.out.println("파일이 존재하지 않습니다.");
        } catch (IOException i) {
            System.out.println("파일을 읽을 수 없습니다.");
        } finally {

        }
    }
}

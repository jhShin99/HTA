package ex18.step2.filereader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample4 {
    public static void main(String[] args) throws FileNotFoundException {
        char[] arr = new char[64];
        try(
            FileReader reader = new FileReader("poem.txt");
            ) {
            while (true) {
                //Returns: The number of characters read
                int num = reader.read(arr);
                // 입력 스트림(reader)에서 10개의 문자를 읽어와 arr[0]부터 10개의 문자를 저장합니다.

                if (num == -1) // 더 이상 읽을 데이터가 없는 경우
                    break;
                System.out.print(new String(arr, 0, num));
            }
        } catch (FileNotFoundException f) {
            System.out.println("파일이 존재하지 않습니다.");
        } catch (IOException i) {
            System.out.println("파일을 읽을 수 없습니다.");
        } finally {
            System.out.println("\n");
            System.out.println("final입니다.");
        }
    }
}

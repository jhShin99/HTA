package ex18.step2.filereader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample3 {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = null;
        char[] arr = new char[64];
        try {
            reader = new FileReader("poem.txt");

            while (true) {
                //Returns: The number of characters read
                int num = reader.read(arr, 0, 10);
                // 입력 스트림(reader)에서 10개의 문자를 읽어와 arr[0]부터 10개의 문자를 저장합니다.
                /**
                 * public int read(char[] cbuf, int offset, int length)
                 * 1. 입력 스트림으로부터 length개의 문자만큼 읽고 cbuf[off]부터 length 개까지 저장합니다.
                 * 2.실제로 읽은 문자의 수가 length보다 작을 경우 읽은 수만큼 리턴합니다.
                 * offset이 0이고 length가 배열의 길이이면 read(char[] cbuf)와 동일합니다.
                 */
                if (num == -1) // 더 이상 읽을 데이터가 없는 경우
                    break;
                System.out.print(new String(arr, 0, num));
            }
        } catch (FileNotFoundException f) {
            System.out.println("파일이 존재하지 않습니다.");
        } catch (IOException i) {
            System.out.println("파일을 읽을 수 없습니다.");
        } finally {
            try {
                //파일을 닫습니다.
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

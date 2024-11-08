package ex18.step2.filereader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 1.파일을 엽니다.
 * 생성자 인자값으로 파일의 위치를 지정합니다.
 * 1)상대경로 : 프로젝트 경로를 기준으로 차례대로 파일의 위치를 지정합니다.
 * 2)절대경로 : 드라이브명부터 차례대로 파일의 위치를 지정합니다.
 * 예) D:/작업폴더/프로젝트/poem.txt
 * 절대경로 지정
 * FileReader reader = new FileReader("D:/workspace_java/java/poem.txt");
 * <p>
 * 2. 파일을 읽어서 처리합니다.
 */
//FileReader 생성자, read method 예외 처리
public class FileReaderExample1 {

    public static void main(String[] args) {
        FileReader reader = null;
        try {
            // 1.파일을 엽니다.
            reader = new FileReader("poem.txt");

            // 2. 파일을 읽어서 처리합니다.
            while (true) {
                int data = reader.read();
                if (data == -1) // 더 이상 읽을 데이터가 없는 경우
                    break;
                char ch = (char) data;
                System.out.print(ch);
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

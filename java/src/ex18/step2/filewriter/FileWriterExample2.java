package ex18.step2.filewriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample2 {

    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            //true : append(원래 있던 파일 내용 뒤에 추가로 쓴다.
            //false : overwrite(덮어 쓰기 한다.)
            writer = new FileWriter("output.txt", true); //파일을 연다
            // public FileWriter(String fileName) throws IOException
            // FileWriter 생성자는 IOException 에러를 발생하기 때문에 IOException 처리문이 있어야 한다.

            String message = "\n감기 조심하세요~";
            writer.write(message);
            writer.write("\n");
        } catch (IOException ioe) {
            System.out.println("파일로 출력할 수 없습니다.");
        } finally {
            try {
                if (writer != null)
                    writer.close(); //파일을 닫습니다.
            } catch (IOException e) {
                System.out.println("파일 닫는 중 오류입니다.");
            }
        }
    }
}

package ex18.step3.bufferedreader_bufferedwriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExampleWrite {

    public static void main(String[] args) {
        String message = "하하입니다. \n오늘도 화이팅입니다.";
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("src/ex18/ex18_buffered/output2.dat"));
            writer.write(message);
        } catch (IOException ioe) { //Exception - IOException
            System.out.println("파일을 읽을 수 없습니다.");
        } finally { //파일을 닫는 명령문을 에러와 상관없이 처리하기 위해 finally 블록에서 사용함.
            try {
                if (writer != null)
                    writer.close(); //파일을 닫는 명령문
            } catch (IOException e) {
                System.out.println("닫는 중 오류입니다.");
            }
        }
    }
}

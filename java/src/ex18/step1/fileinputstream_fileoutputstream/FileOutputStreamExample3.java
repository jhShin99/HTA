package ex18.step1.fileinputstream_fileoutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample3 {

    public static void main(String[] args) {
        byte[] readBytes = new byte[1024];

        String originalFileName = "D:/temp/koala.jpg";
        String targetFileName = "D:/temp2/koala_copy.jpg";

        try(FileInputStream fis = new FileInputStream(originalFileName);
            FileOutputStream fos = new FileOutputStream(targetFileName);
            )
        {
            while(fis.read(readBytes) != -1) {
                //write(byte[] b)
                fos.write(readBytes); //1024바이트를 출력 스트림으로 보냅니다.
            }
            System.out.println("복사가 잘~ 되었습니다.");
        } catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다.");
        } catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다.");
        }
    }
}

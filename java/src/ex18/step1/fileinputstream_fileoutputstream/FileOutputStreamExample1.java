package ex18.step1.fileinputstream_fileoutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample1 {

    public static void main(String[] args) {
        String originalFileName = "D:/temp/koala.jpg";
        String targetFileName = "D:/temp2/koala_copy.jpg";
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(originalFileName);
            fos = new FileOutputStream(targetFileName);

            int readBytes = 0;
            while ((readBytes = fis.read()) != -1)
                fos.write(readBytes);

            System.out.println("복사가 잘~ 되었습니다.");
        } catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다.");
        } catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다.");
        } finally {
            try {
                if (fis != null)
                    fis.close(); //파일을 닫습니다.
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fos != null)
                    fos.close(); //파일을 닫습니다.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package ex18.step4.file;

import java.io.*;

public class FileExampleFileCopy1 {

    public static void main(String[] args) {
        String originalFileName = "D:/temp/koala.jpg";
        String targetFileName = "D:/temp2/test/koala_copy.jpg";

        createDirectory(targetFileName.substring(0, targetFileName.lastIndexOf("/")));
        copy(originalFileName, targetFileName);
    }

    private static void createDirectory(String createDirectory) {
        File directory = new File(createDirectory);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println(directory.getPath() + "에 잘 만들어졌습니다.");
            } else {
                System.out.println(directory.getPath() + " 생성에 실패했습니다.");
            }
        } else {
            System.out.println("이미 디렉토리가 있습니다.");
        }
    }

    private static void copy(String originalFileName, String targetFileName) {
        try (FileInputStream fis = new FileInputStream(originalFileName);
             FileOutputStream fos = new FileOutputStream(targetFileName);
        )
        {
            byte[] readBytes = new byte[1024];
            while (fis.read(readBytes) != -1) {
                //write(byte[] b)
                fos.write(readBytes); // 1024바이트를 출력 스트림으로 보냅니다.
            }

            System.out.println("복사가 잘~ 되었습니다.");
        } catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다.");
        } catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다.");
        }
    }
}

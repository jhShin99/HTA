package ex18.step2.filewriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample3_1 {
    public static void main(String[] args) {
        FileWriter writer = null;

        try {
            writer = new FileWriter("src/ex18/ex18_filewriter/gugu.txt");

            for (int i = 2; i < 10; i++) {
                writer.write("[" + i + "]단\t");
            }
            writer.write("\n");
            for (int i = 1; i < 10; i++) {
                for (int j = 2; j < 10; j++) {
                    writer.write(j + "*" + i + "=" + i*j + "\t");
                }
                writer.write("\n");
            }

        } catch (IOException ioe) {
            System.out.println("파일로 출력할 수 없습니다.");
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                System.out.println("파일을 닫는 중 오류입니다.");
            }
        }
    }
}
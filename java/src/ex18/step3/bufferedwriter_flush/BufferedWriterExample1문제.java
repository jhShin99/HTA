package ex18.step3.bufferedwriter_flush;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample1문제 {

    public static void main(String[] args) {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter("src/ex18/ex18_buffered_flush/output.txt");
            bw = new BufferedWriter(fw, 5);

            char[] arr = {'내', '꺼', '인', '1', '듯', '2', '내', '꺼', '3', '아', '닌', '4', '내', '꺼', '5', '같', '은', '6', '너'};
            for (int cnt = 0; cnt < arr.length; cnt++) {
                bw.write(arr[cnt]);
            }
            //버퍼가 다 차기 전까지는 파일에 실제로 데이터를 쓰지 않습니다.
        } catch (IOException ioe) {
            System.out.println("파일로 출력할 수 없습니다.");
        } finally {
            try {
                if (fw != null)
                    fw.close(); // 아직 버퍼에 데이터가 남아 있는데 출력 스트림 닫습니다.
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

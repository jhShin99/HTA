package ex18.step3.bufferedwriter_flush;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample3문제 {

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
            //버퍼에 있는 데이터를 파일에 즉시 출력하도록 하는 메소드입니다.
            bw.flush();
        } catch (IOException ioe) {
            System.out.println("파일로 출력할 수 없습니다.");
        } finally {
            try {
                if (bw != null)
                    bw.close(); // 보조 기반 스트림이 정상적으로 닫힐 때
                                // 자동으로 flush() 메소드를 호출합니다.
                                // flush() 후 FileWriter의 close() 메소드도 호출됩니다.
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

package ex18.step3.bufferedreader_bufferedwriter;

import java.io.*;

public class BufferedReaderExampleRead {

    public static void main(String[] args) {
        BufferedReader reader = null;
        String message = null;
        try {
            reader = new BufferedReader(new FileReader("src/ex18/ex18_buffered/output2.dat"));

            //더 이상 읽을 데이터가 없는 경우 null을 리턴합니다.
            while((message = reader.readLine()) != null) {
                System.out.println(message);
            }
        } catch (FileNotFoundException fnfe) { //Exception - IOException
            System.out.println("파일이 존재하지 않습니다.");
        } catch (IOException ioe) { //Exception - IOException
            System.out.println("파일을 읽을 수 없습니다.");
        } finally { //파일을 닫는 명령문을 에러와 상관없이 처리하기 위해 finally 블록에서 사용함
            try {
                if (reader != null)
                    reader.close(); //파일을 닫는 명령문
            } catch (IOException e) { // close 메소드가 발생하는 예외 처리
                e.printStackTrace();
            }
        }
    }
}


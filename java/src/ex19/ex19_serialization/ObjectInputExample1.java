//객체를 역직렬화하는 프로그램
//프로그램에 입력된 스트림으로부터 다시 객체를 만들어 내는 작업을 역직렬화(deserialization)라고 합니다.
package ex19.ex19_serialization;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ObjectInputExample1 {

    public static void main(String[] args) {
        /**
         * 1. 파일을 엽니다.
         *
         * ObjectInputStream 클래스는 스트림 형태로 읽어들인 객체를 프로그램에서
         * 사용할 수 있는 객체로 만드는 기능의 클래스입니다.
         * 이 클래스를 FileInputStream 클래스와 함께 사용하면 파일에 저장된 객체를 프로그램에서 다시 읽어서 사용할 수 있습니다.
         * FileInputStream 객체를 생성해서 ObjectInputStream 생성자 파라미터로 넘겨주어야 합니다.
         */
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("output.dat"));
            while (true) {
                /**
                 * 2. 파일 읽기 - 객체를 역직렬화하는 부분입니다.
                 * readObject 메소드 : 입력된 스트림으로부터 객체를 만들어서 리턴하는 메소드로 리턴타입은 Object입니다.
                 * 리턴 타입 Object를 원래의 클래스 타입으로 사용하기 위해 캐스트 연산을 해야합니다.
                 * readObject()가 Object형이므로 GregorianCalendar 타입으로 형 변환 합니다.
                 */
                GregorianCalendar calendar = (GregorianCalendar) in.readObject();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1;
                int date = calendar.get(Calendar.DATE);
                System.out.println(year + "/" + month + "/" + date);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다.");
        } catch (EOFException eofe) { //파일로부터 더 이상 읽을 객체가 없을 때 발생하는 익셉션 처리합니다.
            System.out.println("끝");
        } catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다.");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스가 존재하지 않습니다.");
        } finally {
            try {
                if (in != null)
                    in.close(); //3. 파일을 닫습니다.
            } catch (IOException e) {
                System.out.println("파일을 닫는중 오류입니다.");
            }
        }
    }
}

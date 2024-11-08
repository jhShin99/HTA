//객체를 직렬화하는 프로그램
package ex19.ex19_serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 직렬화: 객체를 네트워크를 통해 전송하거나 파일에 저장하기 위해서 객체를 스트림으로 만드는 작업이 필요합니다.
 *        이런 작업을 자바에서는 객체의 직렬화(serialization)라고 합니다.
 *        즉, 직렬화는 객체를 바이트 형태로 변환하는 과정입니다.
 */
public class ObjectOutputExample1 {

    public static void main(String[] args) {
        /**
         * 1. 파일을 엽니다.
         * ObjectOutputStream 클래스는 객체를 스트림으로 만들어서 출력하는 기능이 있는 클래스입니다.
         * 이 클래스에는 데이터를 파일에 저장하는 기능이 없기 때문에 FileOutputStream 클래스와 함께 사용해야 합니다.
         * FileOutputStream 객체를 생성해서 ObjectOutputStream 클래스의 생성자 파라미터로 넘겨주어야 합니다.
         */

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("output.dat"));

            /**
             * 2. 파일에 쓰기 - 객체를 직렬화 하는 부분입니다.
             * writeObject 메소드 : 파라미터로 넘겨준 객체를 스트림으로 만들어서 출력하는 메소드입니다.
             * 파라미터로 넘겨진 객체가 파일에 저장됩니다.
             * GregorianCalendar 객체를 생성해서 파일에 씁니다.
             */
            out.writeObject(new GregorianCalendar(2023, 0, 14));
            out.writeObject(new GregorianCalendar(2023, 0, 15));
            out.writeObject(new GregorianCalendar(2023, 0,16));

        } catch (IOException ioe) {
            System.out.println("파일로 출력할 수 없습니다.");
        } finally {
            try {
                if (out != null)
                    out.close(); // 3. 파일을 닫습니다.
            } catch (IOException e) {
                System.out.println("파일을 닫는 중 오류 발생했습니다.");
            }
        }
    }
}

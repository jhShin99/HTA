package ex19.ex19_serial_version_uid_no;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputExampleResource {

    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("output10.dat"));) {
            System.out.println("*** 역직렬화 합니다. ***");
            Rectangle obj = (Rectangle) in.readObject();
            System.out.println(obj);

        } catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다.");
        } catch (IOException ioe) {
            //직렬화할 때 사용한 클래스와 역직렬화할 때 사용한 클래스의 버전이
            //다를때 발생하는 에러 메시지 출력하는 곳
            System.out.println(ioe.getMessage());

        } catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스가 존재하지 않습니다.");
        }
    }
}

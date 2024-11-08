package ex19.ex19_serial_version_uid_no;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputExampleResource {
    public static void main(String[] args) {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("output10.dat"));) {
            Rectangle obj = new Rectangle(100, 200);
            System.out.println(obj);

            System.out.println("*** 직렬화 합니다. ***");
            out.writeObject(obj);

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}

package ex19.ex19_serializable_interface;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputExampleResource {

    public static void main(String[] args) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("output2.dat"));)
        {
            out.writeObject(new GoodsStock("70101", 100));
            out.writeObject(new GoodsStock("70102", 50));
            out.writeObject(new GoodsStock("70103", 200));
        } catch (IOException ioe) {
            System.out.println("파일로 출력할 수 없습니다.");
            ioe.printStackTrace();
        }
    }
}

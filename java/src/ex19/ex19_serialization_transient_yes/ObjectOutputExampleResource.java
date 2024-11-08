package ex19.ex19_serialization_transient_yes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputExampleResource {

    public static void main(String[] args) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("output3.dat"));) {

            BBSItem obj = new BBSItem("방탄소년단", "sunshine", "정모합시다.", "이번 주말 어떠세요?");
            System.out.println(obj);

            out.writeObject(obj); // 객체를 직렬화하는 부분

        } catch (IOException ioe) {
            System.out.println("파일로 출력할 수 없습니다.");
            ioe.printStackTrace();
        }
    }
}

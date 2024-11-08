package ex19.ex19_serializable_interface;

import java.io.*;

public class ObjectInputExampleResource {

    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("output2.dat"));)
        {
            while(true) {
                GoodsStock obj = (GoodsStock) in.readObject();
                System.out.println(obj.toString());
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다.");
        } catch (EOFException eofe) {
            System.out.println("끝");
        } catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다.");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스가 존재하지 않습니다.");
        }
    }
}
package ex18.step4.file;

import java.io.File;

public class FileExample6 {

    public static void main(String[] args) {
        String dir = "D:\\newDirectory\\test";

        /**
         * mkdirs() 메서드는 현재 디렉토리와 그 부모 디렉토리를 모두 만들어요
         */

        File f = new File(dir);
        if (!f.exists()) {
            if (f.mkdirs()) {
                System.out.println(f.getPath() + "에 잘 만들어졌습니다.");
            } else {
                System.out.println(f.getPath() + " 생성에 실패했습니다.");
            }
        } else {
            System.out.println("이미 디렉토리가 있습니다.");
        }
    }
}

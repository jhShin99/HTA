package ex18.step4.file;

import java.io.File;
import java.util.Calendar;
import java.util.Random;

public class FileExample7 {

    public static void main(String[] args) {
        String directoryPath = "D:" + File.separator + "test_java" + File.separator + "image";
        createDirectory(directoryPath);
        fileDBName("imsi.png", directoryPath);
    }

    private static void createDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println(directory.getPath() + "에 잘 만들어졌습니다.");
            } else {
                System.out.println(directory.getPath() + " 생성에 실패했습니다.");
            }
        } else {
            System.out.println("이미 디렉토리가 있습니다.");
        }
    }

    private static String fileDBName(String fileName, String saveFolder) {
        // 새로운 폴더 이름 : 오늘 년 + 월 + 일
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR); // 오늘 년도 구합니다.
        int month = c.get(Calendar.MONTH) + 1; // 오늘 월 구합니다.
        int date = c.get(Calendar.DATE); // 오늘 일 구합니다.

        String homedir = saveFolder + File.separator + year + "-" + month + "-" + date;
        System.out.println(homedir);
        File path1 = new File(homedir);
        if (!(path1.exists())) {
            path1.mkdirs(); //새로운 폴더를 생성
        }

        //난수를 구합니다.
        Random r = new Random();
        int random = r.nextInt(100000000);

        /**** 확장자 구하기 시작 ****/
        int index = fileName.lastIndexOf(".");
        // 문자열에서 특정 문자열의 위치 값(index)를 반환합니다.
        // indexOf가 처음 발견되는 문자열에 대한 index를 반환하는 반면
        // lastIndexOf는 마지막으로 발견되는 문자열의 index를 반환합니다.
        // (파일명에 점이 여러개 있을 경우 맨 마지막에 발견되는 문자열의 위치를 리턴합니다.)
        System.out.println("index = " + index);

        String fileExtension = fileName.substring(index + 1);
        System.out.println("fileExtension = " + fileExtension);
        /**** 확장자 구하기 끝 ****/

        //새로운 파일명
        String refileName = "bbs" + year + month + date + random + "." + fileExtension;
        System.out.println("refileName = " + refileName);

        // 오라클 디비에 저장될 파일 명
        String fileDBName = File.separator + year + "-" + month + "-" + date + File.separator + refileName;
        System.out.println("fileDBName = " + fileDBName);
        return fileDBName;
    }
}

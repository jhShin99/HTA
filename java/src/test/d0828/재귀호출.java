package test.d0828;

import java.io.File;

public class 재귀호출 {

    public static void main(String[] args) {
        //조회할 디렉토리 경로 설정
        String directoryPath = "C:\\workspace\\class\\src";

        //File 객체 생성
        File directory = new File(directoryPath);

        //디렉토리가 존재하는지 확인
        if (directory.exists() && directory.isDirectory()) {
            //디렉토리 및 파일 출력
            listFilesAndFolders(directory);
        } else {
            System.out.println("디렉토리가 존재하지 않거나 유효하지 않습니다.");
        }
    }

    public static void listFilesAndFolders(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
                if (file.isDirectory()) {
                    listFilesAndFolders(file);
                }
            }
        }
    }

    //다렉토리 탐색 메서드
    public static void listFilesAndFolders1(File dir) {
        // 주어진 파일이 디렉토리인지 확인
        if (dir.isDirectory()) {
            System.out.println("Directory: " + dir.getPath());

            //디렉토리 내 파일과 폴더 목록 가져오기
            File[] files = dir.listFiles();
            if(files != null) {
                for (File file : files) {
                    // 하위 파일 또는 디렉토리를 재귀적으로 탐색(재귀호출 - recursive call)
                    listFilesAndFolders1(file);
                }
            }
        } else {
            // 디렉토리가 아닌 파일인 경우 출력
            System.out.println("File: " + dir.getPath());
        }
    }
}

package com.naver.myhome.service;

import com.naver.myhome.domain.Board;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public interface BoardService {

    // 글의 개수 구하기
    int getListCount();

    // 글 목록 보기
    List<Board> getBoardList(int page, int limit);

    default public String saveUploadedFile(MultipartFile uploadfile, String saveFolder) throws Exception {
        String originalFileName = uploadfile.getOriginalFilename();
        String fileDBName = fileDBName(originalFileName, saveFolder);

        //파일 저장
        uploadfile.transferTo(new File(saveFolder + fileDBName));

        return fileDBName;
    }

    default public String fileDBName(String fileName, String saveFolder) {
        String dateFolder = createFolderByDate(saveFolder);
        String fileExtension = getFileExtension(fileName);
        String refileName = generateUniqueFileName(fileExtension);
        return File.separator + dateFolder + File.separator + refileName;
    }

    default public int[] getCurrentDate() {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int date = now.getDayOfMonth();

        return new int[]{year, month, date};
    }

    default public String createFolderByDate(String baseFolder) {
        int[] currentDate = getCurrentDate();
        int year = currentDate[0];
        int month = currentDate[1];
        int date = currentDate[2];

        String dateFolder = year + "-" + month + "-" + date;
        String fullFolderPath = baseFolder + File.separator + dateFolder;
        File path = new File(fullFolderPath);

        if (!path.exists()) {
            System.out.println(dateFolder);
            path.mkdirs();
        }

        return dateFolder;
    }

    default public String getFileExtension(String fileName) {

        int index = fileName.lastIndexOf(".");
        return (index > 0) ? fileName.substring(index + 1) : "";
    }

    default public String generateUniqueFileName(String fileExtension) {
        int[] currentDate = getCurrentDate();
        int year = currentDate[0];
        int month = currentDate[1];
        int date = currentDate[2];

        Random r = new Random();
        int random = r.nextInt(100000000);

        return "bbs" + year + month + date + random + "." + fileExtension;
    }

    //글 등록하기
    void insertBoard(Board board);

    void setReadCountUpdate(int number);

    Board getDetail(int number);

    boolean isBoardWriter(int num, String pass);

    int boardModify(Board modifyboard);

    int boardReply(Board board);

    int boardReplyUpdate(Board board);
}

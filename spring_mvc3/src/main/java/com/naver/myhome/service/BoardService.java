package com.naver.myhome.service;

import com.naver.myhome.domain.Board;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

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
    }

    void insertBoard(Board board);
}

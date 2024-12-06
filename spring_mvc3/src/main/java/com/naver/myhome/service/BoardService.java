package com.naver.myhome.service;

import com.naver.myhome.domain.Board;

import java.util.List;

public interface BoardService {

    // 글의 개수 구하기
    int getListCount();

    // 글 목록 보기
    List<Board> getBoardList(int page, int limit);
}

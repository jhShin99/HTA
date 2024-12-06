package com.naver.myhome.mybatis.mapper;

import com.naver.myhome.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {

    // 글의 개수 구하기
    int getListCount();

    List<Board> getBoardList(HashMap<String, Integer> map);

    // 글 등록하기
    public void insertBoard(Board board);

    // 글 내용 보기
    Board getDetail(int num);

    // 조회수 업데이트
    int setReadCountUpdate(int num);

    // 글쓴이인지 확인
    Board isBoardWriter(HashMap<String, Object> map);

    // 글 수정
    int boardModify(Board modifyBoard);

    // BOARD_RE_SEQ 값 수정
    int boardReplyUpdate(Board board);

    // 글 답변
    int boardReply(Board board);

    // 글 삭제
    int boardDelete(Board board);
}

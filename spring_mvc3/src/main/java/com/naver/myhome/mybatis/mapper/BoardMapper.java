package com.naver.myhome.mybatis.mapper;

import com.naver.myhome.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * Mapper 인터페이스란 MyBatis에서 SQL 쿼리를 매핑하고 실행하기 위해 사용하는 인터페이스입니다.
 * MyBatis-Spring은 Mapper 인터페이스를 이용해서 실제 SQL 처리가 되는 클래스를 자동으로 생성합니다.
 */
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

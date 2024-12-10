package com.naver.myhome.mybatis.mapper;

import com.naver.myhome.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Mapper 인터페이스란 MyBatis에서 SQL 쿼리를 매핑하고 실행하기 위해 사용하는 인터페이스입니다.
 * MyBatis-Spring은 Mapper 인터페이스를 이용해서 실제 SQL 처리가 되는 클래스를 자동으로 생성합니다.
 */
@Mapper
public interface CommentMapper {

    public int getListCount(int board_num);

    public List<Comment> getCommentList(Map<String, Integer> map);

    public int commentsInsert(Comment c);

    public int commentsDelete(int num);

    public int commentsUpdate(Comment co);
}

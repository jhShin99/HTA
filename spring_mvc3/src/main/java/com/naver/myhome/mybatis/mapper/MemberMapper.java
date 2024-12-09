package com.naver.myhome.mybatis.mapper;

import com.naver.myhome.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Mapper 인터페이스란 MyBatis에서 SQL 쿼리를 매핑하고 실행하기 위해 사용하는 인터페이스입니다.
 * MyBatis-Spring은 Mapper 인터페이스를 이용해서 실제 SQL 처리가 되는 클래스를 자동으로 생성합니다.
 */
@Mapper
public interface MemberMapper {

    public Member isId(String id);

    public void insert(Member m);

    public int update(Member m);

    public int delete(String id);

    public int getSearchListCount(Map<String, String> map);

    public List<Member> getSearchList(Map<String, Object> map);

    Member getMember_info(String id);
}

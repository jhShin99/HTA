package com.naver.myhome.service;

import com.naver.myhome.domain.Member;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService {

    int isId(String id, String pass);

    void insert(Member m);

    int isId(String id);

    Member member_info(String id);

    void delete(String id);

    int update(Member m);

    List<Member> getSearchList(int index, String search_word, int page, int limit);

    int getSearchListCount(int index, String search_word);
}

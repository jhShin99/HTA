package com.naver.myhome.service;

import com.naver.myhome.domain.Member;
import com.naver.myhome.mybatis.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberMapper dao;

    @Autowired
    public MemberServiceImpl(MemberMapper dao) {
        this.dao = dao;
    }

    @Override
    public int isId(String id, String password) {
        int result = -1; //아이디가 존재하지 않는 경우 - rmember가 null인 경우

        Member rmember = dao.isId(id);
        if (rmember != null) { // 아이디가 존재하는 경우
            if (rmember.getPassword().equals(password)) {
                result = 1; // 아이디와 비밀번호가 일치하는 경우
            } else {
                result = 0; // 아이디는 존재하지만 비밀번호가 일치하지 않는 경우
            }
        }

        return result;
    }

    @Override
    public void insert(Member m) {
        dao.insert(m);
    }

    @Override
    public int isId(String id) {
        Member rmember = dao.isId(id);
        return (rmember == null) ? -1 : 1; //-1은 아이디가 존재하지 않는 경우
                                           // 1은 아이디가 존재하는 경우
    }

    @Override
    public Member member_info(String id) {
        return dao.getMember_info(id);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public int update(Member m) {
        return 0;
    }

    @Override
    public List<Member> getSearchList(int index, String search_word, int page, int limit) {
        return List.of();
    }

    @Override
    public int getSearchListCount(int index, String search_word) {
        return 0;
    }
}

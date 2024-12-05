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
    public int isId(String id, String pass) {
        return 0;
    }

    @Override
    public void insert(Member m) {

    }

    @Override
    public int isId(String id) {
        return 0;
    }

    @Override
    public Member member_info(String id) {
        return null;
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

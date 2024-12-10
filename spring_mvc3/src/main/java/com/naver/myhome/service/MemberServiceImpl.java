package com.naver.myhome.service;

import com.naver.myhome.domain.Member;
import com.naver.myhome.mybatis.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return dao.isId(id);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public int update(Member m) {
        return dao.update(m);
    }

    @Override
    public List<Member> getSearchList(int index, String search_word, int page, int limit) {
        Map<String, Object> map = new HashMap<>();

        // localhost:8088/member/list 로 접속하는 경우
        // select 를 선택하지 않아 index는 "-1"의 값을 갖습니다.
        // 이 경우 아래의 if 문장을 수행하지 않기 때문에 "search_field" 키에 대한 map.get("search_field")의 값은 null이 됩니다.
        if (index != -1) {
            map.put("search_field", index);
            map.put("search_word", "%" + search_word + "%");
        }

        int startrow = (page - 1) * limit + 1;
        int endrow = startrow + limit - 1;
        map.put("start", startrow);
        map.put("end", endrow);

        return dao.getSearchList(map);
    }

    @Override
    public int getSearchListCount(int index, String search_word) {
        // localhost:8088/member/list로 접속하는 경우
        // select를 선택하지 않아 index는 "-1"의 값을 갖습니다.
        // 이 경우 아래의 문장을 수행하지 않기 때문에 "search_field" 키에 대한 map.get("search_field")의 값은 null이 됩니다.
        Map<String, Object> map = new HashMap<>();
        if (index != -1) {
            map.put("search_field", index);
            map.put("search_word", "%" + search_word + "%");
        }

        return dao.getSearchListCount(map);
    }
}

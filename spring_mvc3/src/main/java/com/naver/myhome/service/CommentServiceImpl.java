package com.naver.myhome.service;

import com.naver.myhome.domain.Comment;
import com.naver.myhome.mybatis.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentMapper dao;

    @Autowired
    public CommentServiceImpl(CommentMapper dao) {
        this.dao = dao;
    }


    @Override
    public int getListCount(int board_num) {
        return dao.getListCount(board_num);
    }

    @Override
    public List<Comment> getCommentList(int board_num, int page) {
        int startrow = 1;
        int endrow = page * 3;

        Map<String, Integer> map = new HashMap<>();
        map.put("board_num", board_num);
        map.put("start", startrow);
        map.put("end", endrow);
        return dao.getCommentList(map);
    }

    @Override
    public int commentsInsert(Comment c) {
        return 0;
    }

    @Override
    public int commentsDelete(int num) {
        return 0;
    }

    @Override
    public int commentsUpdate(Comment co) {
        return 0;
    }
}
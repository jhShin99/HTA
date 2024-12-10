package com.naver.myhome.service;

import com.naver.myhome.domain.Comment;
import com.naver.myhome.mybatis.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return List.of();
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

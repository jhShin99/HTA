package com.naver.myhome.controller;

import com.naver.myhome.domain.Comment;
import com.naver.myhome.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/list")
    public Map<String, Object> CommentList(int board_num, int page) {

        List<Comment> list = commentService.getCommentList(board_num, page);
        int listcount = commentService.getListCount(board_num);
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("listcount", listcount);
        logger.info("/comment/list");
        return map;
    }
}

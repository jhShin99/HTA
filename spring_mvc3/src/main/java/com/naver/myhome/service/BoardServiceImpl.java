package com.naver.myhome.service;

import com.naver.myhome.domain.Board;
import com.naver.myhome.mybatis.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardMapper dao;

    @Autowired
    public BoardServiceImpl(BoardMapper dao) {
        this.dao = dao;
    }

    @Override
    public int getListCount() {
        return dao.getListCount();
    }

    @Override
    public List<Board> getBoardList(int page, int limit) {

        HashMap<String, Integer> map = new HashMap<>();
        int startrow = (page - 1) * limit + 1;
        int endrow = startrow + limit - 1;
        map.put("start", startrow);
        map.put("end", endrow);
        return dao.getBoardList(map);
    }

    @Override
    public void insertBoard(Board board) {
        dao.insertBoard(board);
    }

    @Override
    public void setReadCountUpdate(int number) {
        dao.setReadCountUpdate(number);
    }

    @Override
    public Board getDetail(int number) {
        return dao.getDetail(number);
    }

}

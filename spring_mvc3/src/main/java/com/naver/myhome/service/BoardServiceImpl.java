package com.naver.myhome.service;

import com.naver.myhome.domain.Board;
import com.naver.myhome.mybatis.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Override
    public boolean isBoardWriter(int num, String pass) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("num", num);
        map.put("pass", pass);
        Board result = dao.isBoardWriter(map);
        return result != null; // result가 null이면 false, null이 아니면 true 리턴합니다.
    }

    @Override
    public int boardModify(Board modifyboard) {
        return dao.boardModify(modifyboard);
    }

    @Override
    public int boardReplyUpdate(Board board) {
        return dao.boardReplyUpdate(board);
    }

    @Override
    @Transactional
    public int boardReply(Board board) {
        boardReplyUpdate(board);
        board.setBOARD_RE_LEV(board.getBOARD_RE_LEV() + 1);
        board.setBOARD_RE_SEQ(board.getBOARD_RE_SEQ() + 1);
        return dao.boardReply(board);
    }

    @Override
    public int boardDelete(int num) {
        int result = 0;
        Board board = dao.getDetail(num);
        if (board != null) {
            result = dao.boardDelete(board);
        }
        return result;
    }
}

package com.naver.myhome.controller;

import com.naver.myhome.domain.Board;
import com.naver.myhome.domain.PaginationResult;
import com.naver.myhome.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    private BoardService boardService;

    // 클래스에 생성자가 하나만 존재하는 경우 Spring이 자동으로 의존성을 주입해 주므로 @Autowired를 붙일 필요가 없습니다.
    // Spring Boot 2.6 이상에서는 생성자가 하나뿐인 경우 @Autowired를 생략하는 것을 권장합니다.

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping(value = "/list")
    public ModelAndView boardList(@RequestParam(defaultValue = "1") int page,
                                  ModelAndView mv,
                                  HttpSession session) {

        session.setAttribute("referer", "list");
        int limit = 10; // 한 화면에 출력할 로우 개수

        int listcount = boardService.getListCount(); // 총 리스트 수 받아옴
        List<Board> list = boardService.getBoardList(page, limit); // 리스트를 받아옴

        PaginationResult result = new PaginationResult(page, limit, listcount);

        mv.setViewName("board/boardList");
        mv.addObject("page", page);
        mv.addObject("maxpage", result.getMaxpage());
        mv.addObject("startpage", result.getStartpage());
        mv.addObject("endpage", result.getEndpage());
        mv.addObject("listcount", listcount);
        mv.addObject("boardlist", list);
        mv.addObject("limit", limit);

        return mv;
    }

    // 글쓰기
    @GetMapping(value = "/write") // board/write
    public String boardWrite() {
        return "board/boardWrite";
    }

    /**
     * 스프링 컨테이너는 매개변수 Board 객체를 생성하고 Board 객체의 setter 메서드들을 호출하여 사용자 입력값을 설정합니다.
     * 매개변수의 이름과 setter의 property 가 일치하면 됩니다.
     */
    @PostMapping("/add")
    public String add(Board board, HttpServletRequest request) throws Exception {
        String saveFolder = request.getSession().getServletContext().getRealPath("resources/updload");
        MultipartFile uploadfile = board.getUploadfile();

        if (!uploadfile.isEmpty()) {
            String fileDBName = boardService.saveUploadedFile(uploadfile, saveFolder);
            board.setBOARD_FILE(fileDBName); // 바뀐 파일명으로 저장
            board.setBOARD_ORIGINAL(uploadfile.getOriginalFilename()); // 원래 파일명 저장
        }

        boardService.insertBoard(board); // 저장메서드 호출
        logger.info(board.toString()); // selectKey로 정의한 BOARD_NUM 값 확인해 봅시다.
        return "redirect:list";
    }
}

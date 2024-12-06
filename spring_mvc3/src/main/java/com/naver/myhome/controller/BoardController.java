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
import org.springframework.web.bind.annotation.*;
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
 ;
        String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");
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

    //detail?num=9 요청시 파라미터 num의 값을 int num에 저장합니다.
    @GetMapping("/detail")
    public ModelAndView detail(int num,
                               ModelAndView mv,
                               HttpServletRequest request,
                               @RequestHeader(value="referer", required = false) String beforeURL, HttpSession session) {
        /**
         * 1. String beforeURL = request.getHeader("referer"); 의미로
         *    어느 주소에서 detail로 이동했는지 header의 정보 중에서 "referer"를 통해 알 수 있습니다.
         * 2. 수정 후 이곳으로 이동하는 경우 조회수는 증가하지 않도록 합니다.
         * 3. board/list에서 제목을 클릭한 경우 조회수가 증가하도록 합니다.
         *
         */
        String sessionReferer = (String) session.getAttribute("referer");
        logger.info("referer: " + beforeURL);
        if (sessionReferer != null && sessionReferer.equals("list")) {
            if (beforeURL != null && beforeURL.endsWith("list")) {
                boardService.setReadCountUpdate(num);
            }
            session.removeAttribute("referer");
        }

        Board board = boardService.getDetail(num);
        //board=null; //error 페이지 이동 확인하고자 임의로 지정합니다.
        if (board == null) {
            logger.info("상세보기 실패");
            mv.setViewName("error/error");
            mv.addObject("url", request.getRequestURL());
            mv.addObject("message", "상세보기 실패입니다.");
        } else {
            logger.info("상세보기 성공");
            // int count = commentService.getListCount(num);
            int count = 0;
            mv.setViewName("board/boardView");
            mv.addObject("count", count);
            mv.addObject("boarddata", board);
        }
        return mv;
    }
}

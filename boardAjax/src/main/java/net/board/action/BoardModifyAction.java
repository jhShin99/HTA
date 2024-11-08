package net.board.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.board.db.BoardBean;
import net.board.db.BoardDAO;
import net.common.action.Action;
import net.common.action.ActionForward;

import java.io.IOException;

public class BoardModifyAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ActionForward forward = new ActionForward();
        BoardDAO boarddao = new BoardDAO();

        //파라미터로 전달받은 수정할 글 번호를 num 변수에 저장합니다.
        int num = Integer.parseInt(request.getParameter("num"));

        //글 내용을 불러와서 boarddata 객체에 저장합니다.
        BoardBean boarddata = boarddao.getDetail(num);

        //글 내용 불러오기 실패한 경우입니다.
        if (boarddata == null) { {
            System.out.println("(수정)상세보기 실패");}
            forward.setPath("/WEB_INF/views/error/error.jsp");
        } else {
            System.out.println("(수정)상세보기 성공");

            //수정 폼 페이지로 이동할 때 원문 글 내용을 보여주기 때문에 boarddata 객체를
            //request 객체에 저장합니다.
            request.setAttribute("boarddata", boarddata);

            //글 수정 폼 페이지로 이동하기 위해 경로를 설정합니다.
            forward.setPath("/WEB-INF/views/board/boardModify.jsp");
        }
        forward.setRedirect(false);
        return forward;
    }
}

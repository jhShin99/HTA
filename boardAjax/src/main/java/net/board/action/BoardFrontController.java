package net.board.action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.common.action.Action;
import net.common.action.ActionForward;

import java.io.IOException;

@WebServlet("/boards/*")
public class BoardFrontController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("요청 주소: " + request.getRequestURI());

        String RequestURI = request.getRequestURI();
        System.out.println("RequestURI: " + RequestURI);

        String contextPath = request.getContextPath();
        System.out.println("contextPath: " + contextPath);

        //command는 "/list" 반환됩니다.
        String command = RequestURI.substring(contextPath.length() + "/boards".length());
        System.out.println("command: " + command);

        // 초기화
        ActionForward forward = null;
        Action action = null;

        switch (command) {
            case "/list":
                action = new BoardListAction();
                break;
            case "/write":
                action = new BoardWriteAction();
                break;
            case "/add":
                action = new BoardAddAction();
                break;
            case "/detail":
                action = new BoardDetailAction();
                break;
            case "/modify":
                action = new BoardModifyAction();
                break;
            case "/modifyProcess":
                action = new BoardModifyProcessAction();
                break;
            case "/reply":
                action = new BoardReplyAction();
                break;
            case "/replyProcess":
                action = new BoardReplyProcessAction();
                break;
            case "/delete":
                action = new BoardDeleteAction();
                break;
            case "/down":
                action = new BoardFileDownAction();
                break;
            default:
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/error/error.jsp");
                dispatcher.forward(request, response);
                return;
        }

        forward = action.execute(request, response);

        if (forward != null) {
            if (forward.isRedirect()) { // 리다이렉트 됩니다.
                response.sendRedirect(forward.getPath());
            } else { //포워딩됩니다.
                RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
                dispatcher.forward(request, response);
            }
        }

    }

    //doProcess(request, response) 메서드를 구현하여 요청이 GET방식이든
    //POST방식으로 전송되어 오든 같은 메서드에서 요청을 처리할 수 있도록 하였습니다.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }
}

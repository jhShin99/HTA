package net.member.action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.common.action.Action;
import net.common.action.ActionForward;

import java.io.IOException;

@WebServlet("/members/*")
public class MemberFrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("요청 주소: " + request.getRequestURI());

        String RequestURI = request.getRequestURI();
        System.out.println("RequestURI: " + RequestURI);

        String contextPath = request.getContextPath();
        System.out.println("contextPath: " + contextPath);
        //RequestURI에서 컨텍스트 경로 길이 + "/members".length()의 인덱스 위치의 문자부터 마지막 위치 문자까지 추출합니다.
        //command는 "/login" 반환됩니다.
        String command = RequestURI.substring(contextPath.length() + "/members".length());
        System.out.println("command: " + command);

        // 초기화
        ActionForward forward = null;
        Action action = null;

        switch (command) {
            case "/login":
                action = new MemberLoginAction();
                break;
            case "/join":
                action = new MemberJoinAction();
                break;
            case "/idcheck":
                action = new MemberIdCheckAction();
                break;
            case "/joinProcess":
                action = new MemberJoinProcessAction();
                break;
            case "/loginProcess":
                action = new MemberLoginProcessAction();
                break;
            case "/logout":
                action = new MemberLogoutAction();
                break;
            case "/update":
                action = new MemberUpdateAction();
                break;
            case "/updateProcess":
                action = new MemberUpdateProcessAction();
                break;
            case "/list":
                action = new MemberSearchAction();
                break;
            case "/info":
                action = new MemberInfoAction();
                break;
            case "/delete":
                action = new MemberDeleteAction();
                break;
            case "/forbidden":
                action = new ForbiddenAction();
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

package net.template.action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.common.action.Action;
import net.common.action.ActionForward;

import java.io.IOException;

@WebServlet("*.net")
public class TemplateFrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("요청 주소: " + request.getRequestURI());

        /**
         * 요청된 전체 URL중에서 포트 번호 다음부터 마지막 문자열까지 반환됩니다.
         * 예) http://localhost:8088/JSP_Template_JSTL/templateTest.net 인 경우
         *    "/JSP_Template_JSTL/templateTest.net" 반환됩니다.
         */
        //application context에 /JSP_Template_JSTL 입력하기
        String RequestURI = request.getRequestURI();
        System.out.println("RequestURI: " + RequestURI);

        //getContextPath() : 컨텍스트 경로가 반환됩니다.
        //contextPath는 "/JSP_Template_JSTL"가 반환됩니다.
        String contextPath = request.getContextPath();
        System.out.println("contextPath: " + contextPath);

        // RequestURI에서 컨텍스트 경로 길이 값의 인덱스 위치의 문자부터
        // 마지막 위치의 문자까지 추출합니다.
        // command는 "/templateTest.net" 반환됩니다.
        String command = RequestURI.substring(contextPath.length());
        System.out.println("command: " + command);

        // 초기화
        ActionForward forward = null;
        Action action = null;

        switch (command) {
            case "/templateTest.net":
                action = new TemplateTestAction();
                break;

            case "/join.net":
                action = new JoinAction();
                break;

            case "/idCheck.net":
                action = new IdcheckAction();
                break;

            case "/joinProcess.net":
                action = new JoinProcessAction();
                break;

            case "/login.net":
                action = new LoginAction();
                break;

            case "/loginProcess.net":
                action = new LoginProcessAction();
                break;

            case "/logout.net":
                action = new LogoutAction();
                break;

            case "/list.net":
                //필터클래스 만들었으므로 2 안써도됨
                action = new ListAction();
                break;

            case "/update.net":
                action = new UpdateAction();
                break;

            case "/updateProcess.net":
                action = new UpdateProcessAction();
                break;
            case "/info.net":
                //필터클래스 만들었으므로 2 안써도됨
                action = new InfoAction();
                break;
            case "/delete.net":
                action = new DeleteAction();
                break;
            case "/forbidden.net":
                action = new ForbiddenAction();
                break;
            default:
                // .net 으로 못잡는 404는 web.xml에 있음
                RequestDispatcher dispatcher = request.getRequestDispatcher("/error/error404.jsp");
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

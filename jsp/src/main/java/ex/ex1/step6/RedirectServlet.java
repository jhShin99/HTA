package ex.ex1.step6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ex/ex1/step6/RedirectServlet")
public class RedirectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RedirectServlet() {
        super();
    }

    /**
     * 페이지 이동
     * - Redirect 방식 : 이동될 때 브라우저의 주소 표시줄의 URL이 변경되므로 요청이 바뀌게 됩니다.
     * - 이동한 jsp페이지에서는 서블릿에서 request 영역의 속성 값에 접근할 수 없습니다.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("요청방식 : " + request.getMethod());
        System.out.println("파라미터 food의 값 : " + request.getParameter("food"));
        response.sendRedirect("redirect.jsp");
    }
}

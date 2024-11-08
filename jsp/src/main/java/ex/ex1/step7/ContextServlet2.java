package ex.ex1.step7;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/ex/ex1/step7/ContextServlet")
public class ContextServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ContextServlet2() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = request.getParameter("food");
        request.setAttribute("food", value);

        HttpSession session = request.getSession();
        session.setAttribute("food", value);

        /**
         * 웹 애플리케이션이 서비스되고 있는 동안 유지하는 것을 의미합니다.
         * 생명주기가 웹 애플리케이션과 같은 객체는 ServletContext 입니다.
         * ServletContext는 웹 애플리케이션 서비스가 시작될 때 생성되고 종료될 때 소멸합니다.
         */
        ServletContext sc = request.getSession().getServletContext();
        sc.setAttribute("food", value);

        response.sendRedirect("scope.jsp");

    }
}

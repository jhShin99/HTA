package ex.ex1.step7;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/ex/ex1/step7/SessionServlet")
public class RedirectServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RedirectServlet2() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String value = request.getParameter("food");
        request.setAttribute("food", value); //request 객체에 저장합니다.
        session.setAttribute("food", value); //session 객체에 저장합니다.

        response.sendRedirect("redirect.jsp");
    }
}

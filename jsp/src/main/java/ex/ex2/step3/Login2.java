package ex.ex2.step3;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/ex/ex2/step3/login")
public class Login2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Login2() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //파라미터 id의 값을 구해옵니다.
        String id = request.getParameter("id");

        HttpSession session = request.getSession();
        session.setAttribute("id", id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        //이동합니다.
        dispatcher.forward(request, response);
    }
}

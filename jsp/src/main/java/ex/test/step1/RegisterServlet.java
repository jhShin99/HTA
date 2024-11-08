package ex.test.step1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ex/test/step1/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public RegisterServlet() {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String jumin1 = request.getParameter("jumin1");
        String jumin2 = request.getParameter("jumin2");
        String email = request.getParameter("email");
        String domain = request.getParameter("domain");
        String gender = request.getParameter("gender");
        String[] hobby = request.getParameterValues("hobby");
        String post1 = request.getParameter("post1");
        String address = request.getParameter("address");
        String intro = request.getParameter("intro");

        request.setAttribute("id", id);
        request.setAttribute("pass", pass);
        request.setAttribute("jumin1", jumin1);
        request.setAttribute("jumin2", jumin2);
        request.setAttribute("emailAddr", email + "@" + domain);
        request.setAttribute("gender", gender.equals("m") ? "남자" : "여자");
        request.setAttribute("hobby", String.join(" ", hobby));
        request.setAttribute("post1", post1);
        request.setAttribute("address", address);
        request.setAttribute("intro", intro);

        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp"); //상대경로
        dispatcher.forward(request, response);
    }


}

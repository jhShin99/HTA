package ex.ex1.step2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ex/ex1/step2/LifeCycleTest2")
public class LifeCycleTest_post extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String passwd = request.getParameter("passwd");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("웹 애플리케이션 경로 정보: " + request.getContextPath());

        out.println("<br>" + "아이디=" + id + "<br>");
        out.println("비밀번호=" + passwd + "<br>");
        out.close();
    }


}

package ex.test.step2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

//LoginServlet
@WebServlet("/ex/test/step2/login_ok")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        String passwd = request.getParameter("passwd");
        PrintWriter writer = response.getWriter();

        if (!id.equals("java")) {
            writeRespAndRedirect(writer, "아이디");
            return;
        }

        if (!passwd.equals("java")) {
            writeRespAndRedirect(writer, "비밀번호");
            return;
        }
        request.getSession().setAttribute("id", id);
        response.sendRedirect("loginSuccess.jsp");

    }

    private void writeRespAndRedirect(PrintWriter writer, String errorMsg) {
        writer.write(String.format("""
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                <meta charset="UTF-8">
                <title>로그인 오류</title>
                <script>
                alert("%s가 일치하지 않습니다.");
                window.location.href = "login.jsp";
                </script>
                </head>
                <body>
                </body>
                </html>
                """, errorMsg));
    }
}

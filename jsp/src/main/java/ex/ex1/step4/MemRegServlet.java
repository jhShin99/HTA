package ex.ex1.step4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ex/ex1/step4/MemReg")
public class MemRegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String addr = request.getParameter("addr");
        String tel = request.getParameter("tel");
        String hobby = request.getParameter("hobby");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head>"
                + "<style>table{border-collapse:collapse;width:50%;margin:0 auto} "
                + "tr{height:3em;border-bottom:1px solid black} "
                + "td{width:60%}</style></head>");
        out.println("<body><table><tbody>");
        out.println("<tr><th>회원명</th><td> " + name + "</td></tr>");
        out.println("<tr><th>주소</th><td> " + addr + "</td></tr>");
        out.println("<tr><th>전화번호</th><td> " + tel + "</td></tr>");
        out.println("<tr><th>취미</th><td> " + hobby + "</td></tr></tbody></table></body></html>");
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

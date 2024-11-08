package ex.ex1.step3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ex/ex1/step3/ChoiceFruit2")
public class ChoiceFruitServlet2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ChoiceFruitServlet2() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String[] f = request.getParameterValues("fruit");

        out.println("<html><head><style>");
        out.println("body {background-color:black;}");
        out.println("table{background:yellow; margin:0 auto; top:30%; "
                + "position:relative;}");
        out.println("td{color:red; font-size:20px; text-align:center; "
                + "border:1px solid black; height:2em; width:200px;}");
        out.println("</style></head>");
        out.println("<body><table><tbody><tr>");

        for (String fruit : f)
            out.println("<td>" + fruit + "</td>");

        out.println("</tr><tr>");

        for (String fruit : f) {
            /**
             * 1. 상대경로 - 현재 경로를 기준으로 이동해야 합니다. -> 강사 경로
             *    현재 브라우저 주소) http://localhost:8088/JSP/ex1/_4.check_values/choiceFruit2
             *    이미지 주소) http://localhost:8088/JSP/image/apple.png
             *    이미지 경로를 맞추기 위해 '../../image/'로 이동합니다.
             *    out.println("<td><img width=128 height=128 src='../../image/" + fruit + "'></td>");
             *
             * 2. 절대경로 - http://localhost:8088/JSP/image/apple.png
             *    out.println("<td><img width=128 height=128 src='/JSP/image/" + fruit + "'></td>");
             */
            out.println("<td><img width=128 height=128 src='/image/" + fruit + "'></td>"); //절대경로
//            out.println("<td><img width=128 height=128 src='../../image/" + fruit + "'></td>"); //상대경로


        }
        out.println("</tbody></table></body></html>");
        out.close();


        out.close();
    }
}

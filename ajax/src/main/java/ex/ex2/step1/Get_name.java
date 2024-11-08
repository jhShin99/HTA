//1

package ex.ex2.step1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/get_name")
public class Get_name extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String dbq = "\""; //{"name":"홍길동"}
        String message = "{" + dbq + "name" + dbq + ":" + dbq + "홍길동" + dbq + "}";

        //{name:"홍길동"} => error status : parse error
        //String message = "{name:" + dbq + "홍길동" + dbq + "}";

        System.out.println(message);
        response.getWriter().print(message); //json 전달
    }
}

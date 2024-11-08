//4

package ex.ex2.step1;

import com.google.gson.JsonArray;
import ex.ex2.step1.dept.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dept_lib")
public class DeptGet_lib extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = new DAO();
        JsonArray array = dao.getList_lib();

        response.setContentType("application/json; charset=utf-8");
        response.getWriter().print(array);

        System.out.println(array);
    }
}

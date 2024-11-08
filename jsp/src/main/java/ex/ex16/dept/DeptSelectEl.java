package ex.ex16.dept;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/departments/select/el")
public class DeptSelectEl extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public DeptSelectEl() {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = new DAO();
        ArrayList<Dept> list = dao.selectAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ex/ex16/dept/list_el.jsp");
        request.setAttribute("list", list);
        dispatcher.forward(request, response);
    }
}

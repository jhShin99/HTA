package ex.ex12.dept;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

//http://localhost:8088/departments/select
@WebServlet("/departments/select")
public class DeptSelect extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        DAO dao = new DAO();
        ArrayList<Dept> list = dao.selectAll();
        for (Dept dept : list) {
            System.out.println(dept.getDname());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ex/ex12/dept/list.jsp");//View
        request.setAttribute("list", list);
        dispatcher.forward(request, response);
    }
}
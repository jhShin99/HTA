package ex.ex12.dept;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/departments/search")
public class Search extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public Search() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = new DAO();
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        ArrayList<Dept> list = dao.select(deptno);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ex/ex12/dept/list.jsp");
        request.setAttribute("list", list);
        dispatcher.forward(request, response);
    }
}

package ex.ex12.emp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/employees/select")
public class EmpSelect extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = new DAO();
        ArrayList<Emp> list = dao.selectAll();

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ex/ex12/emp/list.jsp");//View
        request.setAttribute("list", list);
        dispatcher.forward(request, response);
    }
}

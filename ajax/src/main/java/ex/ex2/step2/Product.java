package ex.ex2.step2;

import com.google.gson.JsonArray;
import ex.ex2.step2.product.DAO;
import ex.ex2.step2.product.DTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/product")
public class Product extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = new DAO();
        JsonArray array = dao.getList();

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(array);
        System.out.println(array);
    } //doGet end

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DTO vo = new DTO();
        vo.setName(request.getParameter("name"));
        vo.setPrice(Integer.parseInt(request.getParameter("price")));
        vo.setMaker(request.getParameter("maker"));

        DAO dao = new DAO();
        int result = dao.insert(vo);
        if (result == 1) {
            System.out.println("삽입 성공");
        } else {
            System.out.println("삽입 실패");
        }
        doGet(request, response);
    } //doPost end
} //class end

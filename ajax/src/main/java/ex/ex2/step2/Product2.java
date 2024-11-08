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

@WebServlet("/product2")
public class Product2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = new DAO();
        JsonArray array = dao.getList();

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(array);
        System.out.println(array);
    }

    //삭제, 추가, 수정
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int result = 0;
        DAO dao = new DAO();
        String label = request.getParameter("label");
        switch (label) {
            case "삭제":
                result = dao.delete(Integer.parseInt(request.getParameter("id")));
                break;

            case "추가":
            case "수정완료":
                DTO vo = new DTO();
                vo.setName(request.getParameter("name"));
                vo.setPrice(Integer.parseInt(request.getParameter("price")));
                vo.setMaker(request.getParameter("maker"));
                if (label.equals("수정완료")) {
                    vo.setId(Integer.parseInt(request.getParameter("id")));
                    result = dao.update(vo);
                } else {
                    result = dao.insert(vo);
                }
        }

        //result = 0; // - 실패 화면 보기 위한 값
        if (result == 1) {
            System.out.println(label + " 성공");
            doGet(request, response);
        } else {
            System.out.println(label + " 실패");
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print(label + " 실패");
        }
    }
}

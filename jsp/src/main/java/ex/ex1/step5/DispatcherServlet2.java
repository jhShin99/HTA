package ex.ex1.step5;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ex/ex1/step5/DispatcherServlet2")
public class DispatcherServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public DispatcherServlet2() {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("요청방식 : " + request.getMethod());
        System.out.println("파라미터 food의 값 : " + request.getParameter("food"));
        String food = request.getParameter("food");

        request.setAttribute("food", food);
        request.setAttribute("name", "ex");

        //dispatcher.jsp : 이동할 페이지 주소
        RequestDispatcher dispatcher = request.getRequestDispatcher("dispatcher2.jsp"); //상대경로

        dispatcher.forward(request, response);
    }
}

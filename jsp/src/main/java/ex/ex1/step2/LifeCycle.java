//1

package ex.ex1.step2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/LifeCycle", "/a"})
public class LifeCycle extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LifeCycle() {
        super();
        System.out.println("저는 생성자 입니다.~~");
    }

    public void init() throws ServletException {
        System.out.println("저는 init() 입니다.");
    }

    public void destroy() {
        System.out.println("저는 destroy() 입니다.");
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("저는 service() 입니다.");
        System.out.println("요청 주소" + request.getRequestURI());
    }
}

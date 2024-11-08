//3

package ex.ex2.step1;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/get_array_lib")
public class Get_array_lib extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=UTF-8");
        JsonObject json = new JsonObject();
        json.addProperty("name", "홍길동");

        JsonObject json2 = new JsonObject();
        json2.addProperty("name", "이순신");

        JsonArray array = new JsonArray();
        array.add(json);
        array.add(json2);

        System.out.println(array); //[{"name":"홍길동"},{"name":"이순신"}]
        response.getWriter().print(array);
    }
}

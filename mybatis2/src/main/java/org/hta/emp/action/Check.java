package org.hta.emp.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hta.emp.controller.Action;
import org.hta.emp.controller.ActionForward;
import org.hta.emp.dao.EmpDAO;
import org.hta.emp.domain.Emp;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Check implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //선택없이 보내면 deptnos는 null입니다.
        String[] deptnos = request.getParameterValues("deptno");
        Map<String, Object> map = new HashMap<>();
        map.put("deptnos", deptnos);

        EmpDAO dao = new EmpDAO();
        List<Emp> list = dao.getCheck(map);

        ActionForward forward = new ActionForward();
        request.setAttribute("list", list);
        request.setAttribute("deptnos", map.get("deptnos"));
        forward.setPath("_2.foreach/list.jsp");
        forward.setRedirect(false);
        return forward;
    }
}

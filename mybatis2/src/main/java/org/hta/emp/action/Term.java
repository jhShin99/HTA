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

public class Term implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> m = new HashMap<>();
        m.put("start", request.getParameter("startday"));
        m.put("end", request.getParameter("endday"));

        EmpDAO dao = new EmpDAO();
        List<Emp> list = dao.getTermList(m);

        ActionForward forward = new ActionForward();
        request.setAttribute("list", list);
        request.setAttribute("start", m.get("start"));
        request.setAttribute("end", m.get("end"));
        forward.setPath("_1.where/list1.jsp");
        forward.setRedirect(false);

        return forward;
    }
}

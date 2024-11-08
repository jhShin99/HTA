package net.template.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.common.action.Action;
import net.common.action.ActionForward;
import net.template.db.DAO;
import net.template.db.TemplateJoin;

import java.io.IOException;

public class UpdateAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        ActionForward forward = new ActionForward();
        System.out.println("update id=" + id);

        DAO dao = new DAO();
        TemplateJoin temp = dao.selectInfo(id);
        forward.setRedirect(false);
        forward.setPath("/template/update.jsp");
        request.setAttribute("temp", temp);

        return forward;
    }
}

package net.template.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.common.action.Action;
import net.common.action.ActionForward;
import net.template.db.DAO;
import net.template.db.TemplateJoin;

import java.io.IOException;

public class InfoAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DAO dao = new DAO();
        TemplateJoin temp = dao.selectInfo(request.getParameter("id"));

        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath("/template/info.jsp");
        request.setAttribute("temp", temp);

        return forward;
    }
}

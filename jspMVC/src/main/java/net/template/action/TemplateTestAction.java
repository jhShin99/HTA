package net.template.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.common.action.Action;
import net.common.action.ActionForward;

import java.io.IOException;

public class TemplateTestAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String go = request.getParameter("page");
        if (go == null) {
            go="newItem";
        }

        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        request.setAttribute("pageFile", go);
        forward.setPath("/template/templateTest.jsp");
        return forward;
    }
}

package net.template.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.common.action.Action;
import net.common.action.ActionForward;
import net.template.db.DAO;
import net.template.db.TemplateJoin;
import net.template.db.TemplateJoinProcess;

import java.io.IOException;

public class UpdateProcessAction extends TemplateJoinProcess implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateJoin join = getTemplateJoin(request);

        DAO dao = new DAO();
        int result = dao.update(join);
        String message = "회원정보 수정 실패입니다";
        if (result == 1) {
            message = "회원정보 수정 성공입니다.";
        }

        ActionForward forward = new ActionForward();
        forward.setRedirect(true);
        request.getSession().setAttribute("message", message);
        forward.setPath("templateTest.net");

        return forward;
    }
}

package net.template.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.common.action.Action;
import net.common.action.ActionForward;
import net.template.db.DAO;
import net.template.db.TemplateJoin;
import net.template.db.TemplateJoinProcess;

import java.io.IOException;

public class JoinProcessAction extends TemplateJoinProcess implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateJoin join = getTemplateJoin(request);

        DAO dao = new DAO();
        int result = dao.insert(join);

        HttpSession session = request.getSession();
        String message = "회원 가입 성공입니다.";
        if (result != 1) {
            message = "회원 가입 실패입니다.";
        }
        session.setAttribute("message", message);

        ActionForward forward = new ActionForward();
        forward.setRedirect(true);
        forward.setPath("templateTest.net");
        return forward;

    }
}

package net.template.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.common.action.Action;
import net.common.action.ActionForward;
import net.template.db.DAO;

import java.io.IOException;

public class DeleteAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        DAO dao = new DAO();
        int result = dao.delete(id);
        String message = "삭제 실패 입니다.";
        if (result == 1) {
            message = "삭제 성공 입니다.";
        }

        System.out.println(message);
        HttpSession session = request.getSession();
        session.setAttribute("message", message);

        ActionForward forward = new ActionForward();
        forward.setRedirect(true);
        forward.setPath("list.net");
        return forward;
    }
}

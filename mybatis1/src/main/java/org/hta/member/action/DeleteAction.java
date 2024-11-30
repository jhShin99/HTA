package org.hta.member.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;
import org.hta.member.dao.MemberDao;

import java.io.IOException;

public class DeleteAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MemberDao md = new MemberDao();
        int result = md.delete(id);

        String message = (result == 1) ? "삭제 성공입니다." : "삭제 실패입니다.";
        request.setAttribute("message", message);
        request.setAttribute("url", "list.net");

        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath("jsp/message_modal.jsp");
        return forward;
    }
}

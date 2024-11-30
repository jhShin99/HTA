package org.hta.member.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;
import org.hta.member.dao.MemberDao;
import org.hta.member.domain.Member;

import java.io.IOException;

public class UpdateProAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Member mem = new Member();
        mem.setId(request.getParameter("id"));
        mem.setPassword(request.getParameter("password"));

        MemberDao md = new MemberDao();
        int result = md.update(mem);

        String message = (result == 1) ? "수정 성공입니다." : "history.back()";
        request.setAttribute("message", message);

        String url = (result == 1) ? "list.net" : "history.back()";
        request.setAttribute("url", url);

        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath("jsp/message_modal.jsp");
        return forward;
    }
}

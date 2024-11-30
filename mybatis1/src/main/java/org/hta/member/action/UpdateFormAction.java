package org.hta.member.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;
import org.hta.member.dao.MemberDao;
import org.hta.member.domain.Member;

import java.io.IOException;

public class UpdateFormAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        MemberDao md = new MemberDao();
        Member mem = md.select(id);

        ActionForward forward = new ActionForward();
        request.setAttribute("mem", mem);
        forward.setRedirect(false);
        forward.setPath("jsp/updateForm.jsp");
        return forward;
    }
}

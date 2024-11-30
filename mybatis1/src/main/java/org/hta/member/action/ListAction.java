package org.hta.member.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;
import org.hta.member.dao.MemberDao;
import org.hta.member.domain.Member;

import java.io.IOException;
import java.util.List;

public class ListAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MemberDao md = new MemberDao();
        List<Member> list = md.list();

        ActionForward forward = new ActionForward();
        request.setAttribute("list", list);
        forward.setRedirect(false);
        forward.setPath("jsp/list.jsp");
        return forward;
    }
}

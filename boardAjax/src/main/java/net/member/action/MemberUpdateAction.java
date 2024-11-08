package net.member.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.db.Member;
import net.member.db.MemberDAO;

import java.io.IOException;

public class MemberUpdateAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");

        MemberDAO mdao = new MemberDAO();
        Member m = mdao.getMemberById(id);

        ActionForward forward = new ActionForward();
        forward.setPath("/WEB-INF/views/member/updateForm.jsp");
        forward.setRedirect(false);
        request.setAttribute("memberinfo", m);
        return forward;
    }
}

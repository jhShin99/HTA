package org.hta.member.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;
import org.hta.member.dao.MemberDao;
import org.hta.member.domain.Member;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginProAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        Member mem = new Member();
        mem.setId(id);
        mem.setPassword(password);

        MemberDao md = new MemberDao();
        int result = md.chk(mem);


        if (result == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("id", mem.getId());

            request.setAttribute("message", "환영합니다. " + id + "님~");
            request.setAttribute("url", "main.net");
        } else if (result == -1) {
            request.setAttribute("message", "비밀번호가 다릅니다.");
            request.setAttribute("url", "history.back()");
        } else if (result == 0) {
            request.setAttribute("message", "ID가 존재하지 않습니다.");
            request.setAttribute("url", "history.back()");
        }

        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath("jsp/message_modal.jsp");
        return forward;
    }
}

package net.member.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.db.MemberDAO;

import java.io.IOException;
import java.io.PrintWriter;

public class MemberDeleteAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDAO mdao = new MemberDAO();
        String id = request.getParameter("id");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        int result = mdao.delete(id);
        if (result == 1) {
            out.print("<script>");
            out.print("alert('삭제 성공입니다.');");
            out.print("location.href='list'");
            out.print("</script>");
        } else {
            out.print("<script>");
            out.print("alert('회원 삭제 실패입니다.');");
            out.print("history.back()");
            out.print("</script>");
        }
        out.close();
        return null;
    }
}

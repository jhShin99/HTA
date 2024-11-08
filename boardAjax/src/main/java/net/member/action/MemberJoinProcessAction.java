package net.member.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.db.Member;
import net.member.db.MemberDAO;

import java.io.IOException;
import java.io.PrintWriter;

public class MemberJoinProcessAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");

        Member m = new Member();
        m.setId(id);
        m.setPassword(pass);
        m.setName(name);
        m.setAge(age);
        m.setGender(gender);
        m.setEmail(email);

        MemberDAO mdao = new MemberDAO();
        int result = mdao.insert(m);

        //result = 0; //회원 가입 실패 확인을 위한 명령
        if (result == 0) {
            System.out.println("회원 가입 실패입니다.");
            ActionForward forward = new ActionForward();
            forward.setRedirect(false);
            request.setAttribute("message", "회원가입 실패입니다.");
            forward.setPath("/WEB-INF/views/error/error.jsp");
            return forward;
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<script>");
        out.print("alert('회원 가입을 축하합니다.');");
        out.print("location.href='../members/login';");
        out.print("</script>");
        out.close();
        return null;
    }
}

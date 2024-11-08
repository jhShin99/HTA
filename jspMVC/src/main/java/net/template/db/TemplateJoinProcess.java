package net.template.db;

import jakarta.servlet.http.HttpServletRequest;

public class TemplateJoinProcess {

    public TemplateJoin getTemplateJoin(HttpServletRequest request) {
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");

        String jumin1 = request.getParameter("jumin1");
        String jumin2 = request.getParameter("jumin2");
        String jumin = jumin1 + "-" + jumin2;

        String email = request.getParameter("email") + "@" + request.getParameter("domain");
        String gender = request.getParameter("gender");

        String hobby = String.join(",", request.getParameterValues("hobby"));

        String post1 = request.getParameter("post1");
        String address = request.getParameter("address");
        String intro = request.getParameter("intro");

        TemplateJoin join = new TemplateJoin();
        join.setId(id);
        join.setPassword(pass);
        join.setJumin(jumin);
        join.setEmail(email);
        join.setGender(gender);
        join.setHobby(hobby);
        join.setPost(post1);
        join.setAddress(address);
        join.setIntro(intro);
        return join;
    }
}

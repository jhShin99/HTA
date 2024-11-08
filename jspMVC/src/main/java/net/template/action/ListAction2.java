package net.template.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.common.action.Action;
import net.common.action.ActionForward;
import net.template.db.DAO;
import net.template.db.TemplateJoin;

import java.io.IOException;
import java.util.ArrayList;

// InfoAction2, ListAction2 는 filter가 들어감
public class ListAction2 implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        ActionForward forward = new ActionForward();

        // 세션이 없는 상태에서 list.net을 입력한 경우와
        // 아이디가 admin이 아닌 사람도 주소를 아는 다른 사람이 접속하는 경우 실행이 되는 것을 막아야 합니다.
        if (id != null && id.equals("admin")) {
            DAO dao = new DAO();
            ArrayList<TemplateJoin> list = dao.selectAll();
            forward.setRedirect(false);
            forward.setPath("/template/list.jsp");
            request.setAttribute("list", list);
        } else if (id == null) {
            forward.setRedirect(true);
            forward.setPath("login.net");
        } else {
            forward.setRedirect(true);
            forward.setPath("forbidden.net");
        }
        return forward;
    }
}

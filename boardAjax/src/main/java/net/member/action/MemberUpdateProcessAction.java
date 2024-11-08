package net.member.action;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.db.Member;
import net.member.db.MemberDAO;

import java.io.IOException;
import java.io.PrintWriter;

public class MemberUpdateProcessAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String realFolder = "";

        //webapp 아래에 꼭 폴더 생성하세요
        String saveFolder = "memberupload";

        int fileSize = 5 * 1024 * 1024; // 업로드할 파일의 최대 사이즈입니다. 5MB

        //실제 저장 경로를 지정합니다.
        ServletContext sc = request.getServletContext();
        realFolder = sc.getRealPath(saveFolder);
        System.out.println("realFolder=[" + realFolder);
        try {
            MultipartRequest multi =
                    new MultipartRequest(request, realFolder, fileSize, "utf-8",
                            new DefaultFileRenamePolicy());
            String id = multi.getParameter("id");
            String name = multi.getParameter("name");
            int age = Integer.parseInt(multi.getParameter("age"));
            String gender = multi.getParameter("gender");
            String email = multi.getParameter("email");

            String memberfile = multi.getFilesystemName("memberfile");
            System.out.println("memberfile=" + memberfile);

            Member m = new Member();
            m.setAge(age);
            m.setEmail(email);
            m.setGender(gender);
            m.setId(id);
            m.setName(name);
            //m.setPassword(pass);

            if (memberfile != null) { //파일을 선택한 경우
                m.setMemberfile(memberfile);
            } else { //기존 파일 그대로 사용하는 경우
                m.setMemberfile(multi.getParameter("check"));
            }

            MemberDAO mdao = new MemberDAO();
            int result = mdao.update(m);

            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script>");
            //삽입이 된 경우
            if (result == 1) {
                out.print("alert('수정되었습니다');");
                out.print("location.href='../boards/list';");
            } else {
                out.print("alert('회원 정보 수정에 실패했습니다.');");
                out.print("history.back();"); //비밀번호를 제외한 다른 데이터는 유지 되어 있습니다.
            }
            out.print("</script>");
            out.close();
            return null;
        } catch (IOException ex) {
            ex.printStackTrace();
            ActionForward forward = new ActionForward();
            forward.setPath("/WEB-INF/views/error/error.jsp");
            request.setAttribute("message", "프로필 사진 업로드 실패입니다.");
            forward.setRedirect(false);
            return forward;
        } //catch end
    }//execute end
}

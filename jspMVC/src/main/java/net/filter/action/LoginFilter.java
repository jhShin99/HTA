package net.filter.action;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginFilter implements Filter {

    //필터가 생성될 때 초기화시 사용
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoginFilter");
    }

    //<url-pattern>/list.net</url-pattern> 에서 작성된 요청마다 필터가 실행할 메서드
    //HttpServletRequest의 부모가 ServletRequest입니다. HttpServletRequest로 사용하려면 캐스팅을 해주어야 합니다.
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("1");
        //ServletRequest를 HttpServletRequest로 캐스팅하여 getSession 메서드를 사용하여 HttpSession을 가져옵니다.
        HttpServletRequest hprequest = (HttpServletRequest) request;
        HttpSession session = hprequest.getSession();
        String id = (String) session.getAttribute("id");

        HttpServletResponse hpresponse = (HttpServletResponse) response;
        if (id == null) {
            System.out.println("필터:null입니다.");
            hpresponse.sendRedirect("login.net");
            return; //다른 필터로 요청되지 않고 login.net으로 이동합니다.
        }
        // 요청의 필터링 결과를 다음 필터에 전달합니다.
        // 만약 현재 필터가 마지막 필터라면 서블릿 컨테이너에 의해 요청된 서블릿으로 전달됩니다.
        chain.doFilter(request, response);

        //응답 후 코드
        System.out.println("2");
    }
}

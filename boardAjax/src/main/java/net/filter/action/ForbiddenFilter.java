package net.filter.action;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class ForbiddenFilter implements Filter {

    //필터가 생성될 때 초기화시 사용
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ForbiddenFilter");
    }

    //요청 마다 필터가 실행할 메서드
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("3");
        //ServletRequest를 HttpServletRequest로 캐스팅하여 getSession 메서드를 사용하여 HttpSession을 가져옵니다.
        HttpServletRequest hprequest = (HttpServletRequest) request;
        HttpSession session = hprequest.getSession();
        String id = (String) session.getAttribute("id");

        HttpServletResponse hpresponse = (HttpServletResponse) response;
        if (!id.equals("admin")) {
            System.out.println("admin이 아닙니다.");
            hprequest.getRequestDispatcher("forbidden").forward(hprequest, hpresponse);
            return;
        }
        chain.doFilter(request, response);
        System.out.println("4");
    }
}

package net.filter.action;


import jakarta.servlet.*;

import java.io.IOException;

/**
 * 1. 필터란
 *    JSP에서 필터(Filter)는 요청(request)와 응답(response)에 대한 전후 처리를 할 수 있는 기능입니다.
 *    필터는 서블릿(Servlet)과 JSP가 실행되기 전이나 후에 특정 작업을 수행하는데 사용됩니디ㅏ.
 *    주로 인증, 로깅, 요청 파라미터 처리 등에 사용됩니다.
 *
 * 2. 필터의 주요 기능
 *    (1) 요청 전 처리: 클라이언트에서 서버로 들어오는 요청을 가로채어 필요한 전처리를 수행합니다.
 *        예를 들어, 사용자가 로그인했는지 여부를 확인하는 인증 필터를 만들 수 있습니다.
 *    (2) 응답 후 처리: 서블릿이나 JSP가 클라이언트에게 응답을 보낸 후에도 추가 작업을 할 수 있습니다.
 *    (3) 체인 방식 처리: 여러 개의 필터를 체인 형태로 적용할 수 있습니다.
 *        각 필터는 체인의 다음 필터로 요청을 전달할 수 있습니다.
 *
 * 3. 필터 작성
 *    (1) jakarta.servlet.Filter를 구현해야 합니다.
 *
 *    (2) web.xml에 적용할 필터를 순서대로 작성합니다.
 */
public class LoginFilter_설명 implements Filter {

    //웹 애플리케이션이 시작될 때 서블릿 컨테이너에 의해 초기화됩니다.
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("초기화:필터1");
    }

    //요청시마다 필터가 실행할 메서드
    //HttpServletRequest의 부모가 ServletRequest입니다. HttpServletRequest로 사용하려면 캐스팅을 해주어야 합니다.
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //요청 전 처리 코드

        //요청의 필터링 결과를 다음 필터에 전달합니다.
        //만약 현재 필터가 마지막 필터라면 서블릿 컨테이너에 의해 요청된 서블릿으로 전달됩니다.
        chain.doFilter(request, response);

        //응답 후 처리 코드
        System.out.println("2");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    //웹 애플리케이션이 시작될 때 서블릿 컨테이너에 의해 초기화됩니다.

}

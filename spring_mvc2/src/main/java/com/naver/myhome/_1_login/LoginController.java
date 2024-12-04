package com.naver.myhome._1_login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 1. @Controller 어노테이션을 사용한 컨트롤러 클래스를 이용해서 특정 요청 URL을 처리합니다.
 * 2. @Component를 상속한 @Controller는 @Controller가 붙은 클래스의 객체를 메모리에 생성하는 기능을 제공합니다.
 * 3. 단순히 객체를 생성하는 것에 그치지 않고 DispatcherServlet이 인식하는 Controller 객체로 만들어 줍니다.
 * 4. 스프링 컨테이너는 @Controller가 선언된 객체를 자동으로 Controller 객체로 인식합니다.
 */
@Controller
public class LoginController {
    /**
     * 1. @GetMapping(value= "/login")은 Spring Boot의 MVC(Model-View-Controller) 패턴에서 사용하는
     *    annotation 입니다.
     *    HTTP GET 요청을 특정 메서드와 매핑해주는 역할을 합니다.
     *
     * 2. value 속성은 "요청 경로"를 작성합니다.
     *    예를 들어, value = "/login" 은 "/login" URL로 들어오는 GET 요청을 처리하겠다는 의미입니다.
     *    클라이언트가 /login 경로로 GET 요청을 보낼 때 이 annotation 이 붙은 메서드가 호출됩니다.
     *
     * 3. @GetMapping, @PostMapping 뒤에는 반드시 메서드가 나와야 하고 자동 호출 됩니다.
     *    이름은 다른 메서드들과 중복되지 않도록 합니다.
     *
     */

    @GetMapping(value = "/login")
    public String login() {

        //반환형이 String형인 경우 View 이름을 리턴합니다.
        return "login/loginForm"; //WEB-INF/views/login/loginForm.jsp 이곳으로 이동해라
    }
}

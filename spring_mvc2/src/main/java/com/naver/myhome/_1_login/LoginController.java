package com.naver.myhome._1_login;

import com.naver.myhome.model.BbsBean;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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

    /**
     * ModelAndView 이용해서 데이터 전달 방법
     * ① 스프링에서 Model 객체는 컨트롤러에서 생성된 데이터를 담아서 jsp 페이지에 전달하는 역할을 합니다.
     * ② 서블릿에서 request.setAttribute()와 유사한 역할을 합니다.
     * ③ 전달할 데이터와 View 페이지 정보를 한꺼번에 저장할 수 있는 객체는 ModelAndView 입니다.
     * ④ ModelAndView에서 데이터를 저장할 때 사용하는 메서드는 addObject(String, Object) 입니다.
     */
//    @PostMapping(value = "/login_ok1.do")
    public ModelAndView login_ok(HttpServletRequest request, ModelAndView mv) {
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");

        BbsBean bbs = new BbsBean();
        bbs.setId(id);
        bbs.setPass(pass);

        mv.setViewName("login/list"); //WEB-INF/views/login/list.jsp
        mv.addObject("bkey", bbs);
        /**
         * addObject의 첫 번째 매개변수는 키(Key), 두 번째 매개변수는 값(Value)을 의미합니다.
         * bbs는 id와 비밀번호가 저장되어 있는 객체 입니다.
         * ModelAndView에 값을 저장한 것은 WEB-INF/views/login/list.jsp에서 EL로 나타낼 수 있습니다.
         * ID : ${bkey.id} <br>
         * 비밀번호 : ${bkey.pass} <br>
         */
        return mv;
        /**
         * WEB-INF/views/login/list.jsp의 내용이 보이지만 포워딩되어 주소는
         * localhost:8088/login_ok1.do를 나타냅니다.
         * 리다이렉트를 원하면 'redirect:' 라는 접두사를 붙입니다.
         */
    }

    /**
     * Model 이용해서 데이터 전달 방법
     * ① View 페이지에 대한 정보는 반환형 String에 나타냅니다.
     * ② Model에서 데이터를 저장할 때 사용하는 메서드는 addAttribute(String, Object)입니다.
     *
     */
    @PostMapping(value = "/login_ok1.do")
    public String login_ok1(HttpServletRequest request, Model mv) {

        String id = request.getParameter("id");
        String pass = request.getParameter("pass");

        BbsBean bbs = new BbsBean();
        bbs.setId(id);
        bbs.setPass(pass);

        mv.addAttribute("bkey", bbs);

        return "login/list";
    }
}

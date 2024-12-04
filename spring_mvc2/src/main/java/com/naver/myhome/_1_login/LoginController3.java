package com.naver.myhome._1_login;

import com.naver.myhome.model.BbsBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController3 {

    @GetMapping(value = "/login3")
    public String login3(){
        return "login/loginForm3";
    }

    /**
     * command 객체에 접근할 때 사용할 속성 명을 변경하고 싶다면 @ModelAttribute를 사용합니다.
     * 예) @ModelAttribute("hoho") BbsBean bbs
     *     view 페이지에서 "hoho"라는 이름으로 사용하면 됩니다.
     *
     *     <th>ID</th><td>${hoho.id}</td>
     */
    @PostMapping(value = "/login_ok3.do")
    public String login_ok3(@ModelAttribute("hoho") BbsBean bbs) {
        return "login/list3";
    }
}

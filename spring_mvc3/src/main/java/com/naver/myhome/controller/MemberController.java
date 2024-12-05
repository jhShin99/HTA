package com.naver.myhome.controller;

import com.naver.myhome.domain.Member;
import com.naver.myhome.service.MemberService;
import jakarta.servlet.http.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Component를 이용해서 스프링 컨테이너가 해당 클래스 객체를 생성하도록 설정할 수 있지만
 * 모든 클래스에 @Component를 할당하면 어떤 클래스가 어떤 역할을 수행하는지 파악하기
 * 어렵습니다. 스프링 프레임워크에서는 이런 클래스들을 분류하기 위해서
 * @Component를 상속하여 다음과 같은 세 개의 어노테이션을 제공합니다.
 *
 * 1. @Controller - 사용자의 요청을 제어하는 Controller 클래스
 * 2. @Repository - 데이터 베이스 연동을 처리하는 DAO 클래스
 * 3. @Service - 비즈니스 로직을 처리하는 Service 클래스
 */

@Controller
@RequestMapping(value = "/member")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * @CookieValue(value="saveid", required=false) Cookie readCookie
     * 이름이 saveid인 쿠키를 Cookie 타입으로 전달받습니다.
     * 지정한 이름의 쿠키가 존재하지 않을 수도 있기 때문에 required=false로 설정해야 합니다.
     * 즉, id 기억하기를 선택하지 않을 수도 있기 때문에 required=false로 설정해야 합니다.
     * required=true 상태에서 지정한 이름을 가진 쿠키가 존재하지 않으면 스프링 MVC는 예외를 발생시킵니다.
     */
    //로그인 폼이동
    @GetMapping(value = "/login")
    public ModelAndView login(ModelAndView mv,
                              @CookieValue(value = "saveid", required = false) Cookie readCookie) {
        if (readCookie != null) {
            mv.addObject("saveid", readCookie.getValue());
            logger.info("saveid={}", readCookie.getValue());
        }
        mv.setViewName("member/loginForm");
        return mv;
    }

    @GetMapping(value = "/join")
    public String join() {
        return "member/joinForm";
    }

    @ResponseBody
    @GetMapping(value = "/idcheck")
    public int idcheck(String id) {
        return memberService.isId(id);
    }

    @PostMapping("/joinProcess")
    public String joinProcess(@ModelAttribute Member member) {
        memberService.insert(member);
        return "redirect:/member/login";
    }
}

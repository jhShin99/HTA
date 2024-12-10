package com.naver.myhome.controller;

import com.naver.myhome.domain.Member;
import com.naver.myhome.domain.PaginationResult;
import com.naver.myhome.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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

    //로그인 처리
    @PostMapping(value = "/loginProcess")
    public String loginProcess(
            String id,
            String password,
            @RequestParam(defaultValue = "") String remember,
            HttpServletResponse response,
            HttpSession session,
            RedirectAttributes rattr) {

        int result = memberService.isId(id, password);
        logger.info("결과 : {}", result);

        if (result == 1) {
            //로그인 성공
            session.setAttribute("id", id);
            Cookie savecookie = new Cookie("saveid", id);
            if (!remember.equals("")) { //remember 선택한 경우
                savecookie.setMaxAge(60*60*24); //1일
                logger.info("쿠키저장 : 60*60*24");
            } else {
                logger.info("쿠키저장 : 0");
                savecookie.setMaxAge(0);
            }
            response.addCookie(savecookie);
            return "redirect:/board/list"; //localhost:8088/board/list
        } else {
            rattr.addFlashAttribute("result", result);
            return "redirect:login"; //localhost:8088/member/login
        }
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
    public String joinProcess(@ModelAttribute Member member, RedirectAttributes rattr) {
        memberService.insert(member);
        /**
         * 스프링에서 제공하는 RedirectAttributes는 기존의 Servlet에서 사용되던
         * response.sendRedirect()를 사용할 때와 동일한 용도로 사용합니다.
         * 리다이렉트로 전송하면 파라미터를 전달하고자 할 때 addAttribute()나 addFlashAttribute()를 사용합니다.
         * 예) response.sendRedirect("/test?result=1");
         *     => rattr.addAttribute("result", 1)
         */
        rattr.addFlashAttribute("result", "joinSuccess");
        return "redirect:login";
    }

    @GetMapping(value = "/logout")
    public String loginout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }

    //회원 정보 수정폼
    @GetMapping(value = "/update")
    public ModelAndView update(HttpSession session, ModelAndView mv) {
        String id = (String) session.getAttribute("id");

        if (id == null) {
            mv.setViewName("redirect:login");
            logger.info("id is null");
        } else {
            Member m = memberService.member_info(id);
            mv.setViewName("member/memberUpdateForm");
            mv.addObject("memberinfo", m);
        }
        return mv;
    }

    //수정처리
    @PostMapping(value = "/updateProcess")
    public String updateProcess(Member member, Model model,
                                HttpServletRequest request,
                                RedirectAttributes rattr) {

        int result = memberService.update(member);
        if (result == 1) {
            rattr.addFlashAttribute("result", "updateSuccess");
            return "redirect:/board/list";
        } else {
            model.addAttribute("url", request.getRequestURI());
            model.addAttribute("message", "정보 수정 실패");
            return "error/error";
        }
    }

    /**
     * 1. header.jsp에서 이동하는 경우
     *    href="${pageContext.request.contextPath}/member/list"
     * 2. member_list.jsp에서 이동하는 경우
     *    <a href="list?page=2&search_field=-1&search_word=" class="page-link">2</a>
     */
    @GetMapping(value = "/list")
    public ModelAndView memberList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int limit,
            ModelAndView mv,
            @RequestParam(value = "search_field", defaultValue = "-1") int index,
            @RequestParam(defaultValue = "") String search_word
    ) {
        int listcount = memberService.getSearchListCount(index, search_word); // 총 리스트 수를 받아옴

        List<Member> list = memberService.getSearchList(index, search_word, page, limit);

        PaginationResult result = new PaginationResult(page, limit, listcount);

        mv.setViewName("member/memberList");
        mv.addObject("page", page);
        mv.addObject("maxpage", result.getMaxpage());
        mv.addObject("startpage", result.getStartpage());
        mv.addObject("endpage", result.getEndpage());
        mv.addObject("listcount", listcount);
        mv.addObject("memberlist", list);
        mv.addObject("search_field", index);
        mv.addObject("search_word", search_word);
        return mv;
    }

    // 회원의 개인 정보
    @GetMapping(value = "/info")
    public ModelAndView member_info(String id,
                                    ModelAndView mv,
                                    HttpServletRequest request) {
        Member m = memberService.member_info(id);
        // m=null; // 오류 확인하는 값
        if (m != null) {
            mv.setViewName("member/memberInfo");
            mv.addObject("memberinfo", m);
        } else {
            mv.addObject("url", request.getRequestURL());
            mv.addObject("message", "해당 정보가 없습니다.");
            mv.setViewName("error/error");
        }
        return mv;
    }

    // 삭제
    @GetMapping(value = "/delete")
    public String member_delete(String id) {
        memberService.delete(id);
        return "redirect:list";
    }
}

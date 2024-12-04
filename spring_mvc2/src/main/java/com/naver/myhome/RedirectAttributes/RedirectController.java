package com.naver.myhome.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {

    @GetMapping(value = "/delete")
    public String delete(HttpSession session) {
        session.setAttribute("message", "삭제되었습니다.");
        return "redirect:/output";
    }

    @GetMapping(value = "/output")
    public String output() {
        return "change/output";
    }

    @GetMapping(value = "/delete2")
    public String delete2(RedirectAttributes rattr) {
        //addFlashAttribute()는 일회성으로 데이터를 전달합니다.
        rattr.addFlashAttribute("flashMessage2", "삭제되었습니다.");
        return "redirect:/output2";
    }

    @GetMapping(value = "/output2")
    public String output2() {
        return "change/output2";
    }

    @GetMapping(value = "/delete3")
    public String delete3(RedirectAttributes rattr) {
        rattr.addFlashAttribute("flashMessage3", "삭제되었습니다.");

        //redirect의 파라미터로 보냅니다.
        // localhost:8088/delete3?attr=addAttribute
        rattr.addAttribute("attr", "addAttribute");
        return "redirect:/output3";
    }

    @GetMapping(value = "/output3")
    public String output3() {
        return "change/output3";
    }
}

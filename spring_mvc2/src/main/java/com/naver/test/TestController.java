package com.naver.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @GetMapping("/join")
    public String join() {
        return "test/loginForm";
    }

    @PostMapping("/joinProcess")
    public String joinProcess(@RequestParam("id") String id,
                              @RequestParam("pass") String password,
                              @RequestParam("jumin1") String jumin1,
                              @RequestParam("jumin2") String jumin2,
                              @RequestParam("email") String email,
                              @RequestParam("domain") String domain,
                              @RequestParam("gender") String gender,
                              @RequestParam("hobby") String hobby,
                              @RequestParam("post1") String post1,
                              @RequestParam("address") String address,
                              @RequestParam("intro") String intro,
                              Model model) {
        model.addAttribute("id", id);
        model.addAttribute("password", password);
        model.addAttribute("jumin1", jumin1);
        model.addAttribute("jumin2", jumin2);
        model.addAttribute("email", email);
        model.addAttribute("domain", domain);
        model.addAttribute("gender", gender);
        model.addAttribute("hobby", hobby);
        model.addAttribute("post1", post1);
        model.addAttribute("address", address);
        model.addAttribute("intro", intro);
        return "test/info";
    }
}

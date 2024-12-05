package com.naver.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @GetMapping("/join")
    public String join() {
        return "test/loginForm";
    }

    @PostMapping("/joinProcess")
    public String joinProcess(@ModelAttribute Join join) {
        return "test/join";
    }
}

package com.naver.myhome._2_RequestParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CheckController2 {

    @GetMapping(value = "/check2")
    public String check2() {
        return "check/checkForm2";
    }

    @PostMapping(value = "/check2.do")
    public String check2_do(String[] hobby, Model mv) {
        mv.addAttribute("hobby", hobby);
        return "check/list2";
    }
}

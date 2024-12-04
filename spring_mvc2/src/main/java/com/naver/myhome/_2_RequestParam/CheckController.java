package com.naver.myhome._2_RequestParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CheckController {

    @GetMapping("/check")
    public String check() {
        return "check/checkForm";
    }

    @PostMapping(value = "/check.do")
    public String check_do(String[] hobby, Model mv) {
        //String.join(",", hobby) : String[] 배열을 콤마로 구분된 String 으로 변환
        mv.addAttribute("hobby", String.join(",", hobby));
        System.out.println(String.join(",", hobby));
        return "check/list1";
    }
}

package com.naver.myhome._2_RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParamController2 {

    @GetMapping(value = "/param6")
    public String param6() {
        return "param/paramForm6";
    }

    //name="age"가 두 개 있는 경우 - 한 개의 값 뒤에 "," 후 또 한 번 붙음
    @GetMapping(value = "/param6.do")
    public String param6(String age, Model model, HttpServletRequest request) {
        System.out.println("age=" + age); //12, 34
        model.addAttribute("age", age);
        model.addAttribute("url", request.getRequestURI());
        return "param/list1";
    }

    @GetMapping(value = "/param7")
    public String param7() {
        return "param/paramForm7";
    }

    //name="age"가 두 개 있는 경우
    @GetMapping(value = "/param7.do")
    public String param7(String[] age, Model model, HttpServletRequest request) {
        model.addAttribute("ages", age);
        model.addAttribute("url", request.getRequestURI());
        return "param/list2";
    }
}

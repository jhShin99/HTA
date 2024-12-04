package com.naver.myhome._2_RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController1 {

    @GetMapping("/param1")
    public String param1() {
        return "param/paramForm1";
    }

    /**
     * 1. 정상실행
     *    Command 객체에 없는 파라미터를 처리하는 방법
     * @RequestParam(value="age") int age
     * 파라미터 age를 정수형 변수 age에 저장하라는 의미입니다.
     * String으로 넘어오는 파라미터의 값을 변수형에 맞추어 캐스팅합니다.
     *
     * int age = Integer.parseInt(request.getParameter("age"));
     *
     * @RequestParam(value = "age") int age => @RequestParam int age
     */

    @PostMapping(value = "/param1.do")
    public String param1int(@RequestParam(value = "age") int age,
                            Model model,
                            HttpServletRequest request) {
        model.addAttribute("age", age);
        model.addAttribute("url", request.getRequestURI());

        return "param/list1";
    }

    @GetMapping(value = "/param2")
    public String param2() {
        return "param/paramForm2";
    }

    /**
     * 2. @RequestParam(value="age")에서 @RequestParam(value="age2")로 수정
     * HTTP Status 400 - Bad Request Message
     * Required int parameter 'age2' is not present
     */
    @PostMapping(value = "/param2.do")
    public String param2(@RequestParam(value = "age2") int age, Model model) {
        model.addAttribute("age", age);
        return "param/list1";
    }

    @GetMapping(value = "/param3")
    public String param3() {
        return "param/paramForm3";
    }

    // 400 오류 발생 해결법
    // Optional int parameter 'age2' is present but cannot be translated into a null
    // value due to being declared as a primitive type
    // required=false로 400오류는 발생하지 않지만 넘어온 값이 null이라 이것을 기본형 int형으로 변환하면서 500 오류 발생
    @PostMapping(value = "/param3.do")
    public String param3(
            @RequestParam(value = "age2", required = false) int age,
            Model model
    ) {
        model.addAttribute("age", age);
        return "param/list1";
    }

    @GetMapping(value = "/param4")
    public String param4() {
        return "param/paramForm4";
    }

    /**
     * 위 예제에서 400번 오류는 없어졌지만 500오류 발생했습니다.
     * 오류 수정 방법 - age2라는 파라미터가 없는 경우 기본값으로 10을 설정합니다.
     * @RequestParam(value="age2", defaultValue="10", required = false) int age, Model model)
     */
    @PostMapping(value = "/param4.do")
    public String param4(@RequestParam(value = "age2", defaultValue = "10", required = false) int age
            , Model model
            , HttpServletRequest request) {
        model.addAttribute("url", request.getRequestURI());
        model.addAttribute("age", age);
        return "param/list1";
    }

    @GetMapping(value = "/param5")
    public String param5() {
        return "param/paramForm5";
    }

    // int age : 파라미터와 같은 이름의 변수에 저장할 경우 이와 같이 작성하면 됩니다.
    @PostMapping(value = "/param5.do")
    public String param5(int age, Model model, HttpServletRequest request) {
        model.addAttribute("age", age);
        model.addAttribute("url", request.getRequestURI());
        return "param/list1";
    }
}

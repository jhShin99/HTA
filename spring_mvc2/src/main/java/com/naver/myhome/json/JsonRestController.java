package com.naver.myhome.json;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @ResponseBody + @Controller
public class JsonRestController {

    //반환형이 스트링이고 @ResponseBody가 있으면 문자열을 응답으로 보냅니다.
      //@ResponseBody
    @GetMapping(value = "/url33")
    public String url33() {
        return "리턴되는 문자열이 주소에 대한 정보가 아니라 응답으로 보내 브라우저에 보입니다.";
    }
}

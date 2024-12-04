package com.naver.myhome.json;

import com.naver.myhome.model.BbsBean;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class JsonController {

    //반환형이 스트링이면 이동할 페이지를 의미합니다.

    @GetMapping(value = "/url")
    public String url() {
        return "json/url1";
    }

    @GetMapping(value = "/url2")
    public void url2(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("[url2에서 보냅니다.]");
    }

    //반환형이 스트링이고 @ResponseBody가 있으면 문자열을 응답으로 보냅니다.
    @ResponseBody
    @GetMapping(value = "/url3")
    public String url3() {
        return "리턴되는 문자열이 주소에 대한 정보가 아니라 응답으로 보내 브라우저에서 보입니다.";
    }

    @GetMapping(value = "/url4")
    public void url4(HttpServletResponse response) throws IOException {
        BbsBean bean = new BbsBean();
        bean.setId("hta");
        bean.setPass("like");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(bean); //error status : parser error => json 스트링 형식으로 보내야 합니다.
    }

    //{"id":"hta","pass":"like"}
    @ResponseBody
    @GetMapping(value = "/url5")
    public BbsBean url5() {
        BbsBean bean = new BbsBean();
        bean.setId("hta");
        bean.setPass("홍길동");
        return bean;
    }
}

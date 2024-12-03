package com.naver.myhome1.sample1_1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");

        MessageBean m = (MessageBean) ctx.getBean("m");
        MessageMultiple bean = (MessageMultiple) ctx.getBean("m2");

        //3. 메서드 실행합니다.
        bean.print();

        //4. Spring 컨테이너를 종료합니다.
        ctx.close();
    }
}

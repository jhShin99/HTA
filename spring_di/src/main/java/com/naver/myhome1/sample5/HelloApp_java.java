package com.naver.myhome1.sample5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp_java {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");

        System.out.println("========== getBean() 전 ==========");
        // Object getBean(String name) :
        // argument로 지정된 이름의 bean 인스턴스를 반환합니다.
        // applicationContext.xml에서 id가 "m3"인 bean을 가져옵니다.
        MessageBean bean = (MessageBean) ctx.getBean("m3");

        bean.sayHello(); //메서드 호출합니다.

        ctx.close();
        
    }
}

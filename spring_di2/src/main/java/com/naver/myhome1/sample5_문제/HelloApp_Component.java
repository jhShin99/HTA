package com.naver.myhome1.sample5_문제;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp_Component {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("myhome1/sample5_문제/applicationContext5_3.xml");
        MessageBeanImpl m3 = (MessageBeanImpl) ctx.getBean("m3");

        m3.sayHello();
        ctx.close();
    }
}

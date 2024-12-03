package com.naver.myhome1.sample5_1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp_Component {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("myhome1/sample5_1/applicationContext5_1.xml");
        ReadTest1 test = (ReadTest1) ctx.getBean("readTest1");
        test.print();
    }
}

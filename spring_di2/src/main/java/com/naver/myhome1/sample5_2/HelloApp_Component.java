package com.naver.myhome1.sample5_2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp_Component {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("myhome1/sample5_2/applicationContext5_2.xml");
        ReadTest2 test = (ReadTest2) ctx.getBean("readTest2");
        test.print();
    }
}

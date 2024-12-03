package com.naver.myhome1.sample5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp_java {

    public static void main(String[] args) {

        MessageBeanImpl bean = new MessageBeanImpl("Spring");
        FileOutputter fo = new FileOutputter(); //
        fo.setFilePath("out.txt");

        bean.setGreeting("안녕하세요!");
        bean.setOutputter(fo); //
        bean.sayHello();
        
    }
}

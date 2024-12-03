package com.naver.myhome1.sample5_문제;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("m3")
public class MessageBeanImpl implements MessageBean {
    @Value("${name}")
    private String name;

    @Value("${greeting}")
    private String greeting;


    private Outputter outputter;

    @Autowired
    public MessageBeanImpl(Outputter outputter) {
        this.outputter = outputter;
        System.out.println("MessageBeanImpl 생성자 입니다.");
    }

    @Override
    public void sayHello() {
        String message = greeting + name + "!";
        System.out.println("MessageBeanImpl의 sayHello() 호출 : " + message);
        try {
            outputter.output(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

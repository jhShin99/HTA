package com.naver.myhome1.sample5;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean {

    private String name;
    private String greeting;
    private Outputter outputter;

    public MessageBeanImpl(String name) {
        this.name = name;
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

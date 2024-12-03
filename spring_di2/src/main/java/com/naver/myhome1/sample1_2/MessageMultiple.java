package com.naver.myhome1.sample1_2;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageMultiple {

    private MessageBean messageBean;

    //해당 타입에 할당할 수 있는 빈 객체를 찾아서 자동 주입됩니다.
    //반드시 주입할 의존 객체가 존재해야합니다.

    @Autowired
    public void setBean(MessageBean messageBean) {
        this.messageBean = messageBean;
    }

    public MessageMultiple() {
        System.out.println("MessageMultiple 생성자입니다.");
    }

    public void print() {
        messageBean.sayHello("Spring");
    }
}

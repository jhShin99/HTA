package com.naver.myhome1.sample1_1;

public class MessageMultiple {

    private MessageBean messageBean;

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

package com.naver.myhome1.sample5;

public class HelloApp {

    public HelloApp() {

    }

    public static void main(String[] args) {
        MessageBeanImpl messageBean = new MessageBeanImpl("Spring");
        FileOutputter fileOutputter = new FileOutputter();
        fileOutputter.setFilePath("filePath");
        messageBean.setGreeting("안녕하세요!");
        messageBean.setOutputter(fileOutputter);
        messageBean.sayHello();
    }
}

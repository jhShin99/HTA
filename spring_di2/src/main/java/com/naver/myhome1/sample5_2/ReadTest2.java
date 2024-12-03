package com.naver.myhome1.sample5_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReadTest2 {

    @Value("${name}")
    private String readName;

    @Value("${age}")
    private int readAge;

    public void print() {
        System.out.println(readName);
        System.out.println(readAge);
    }

}

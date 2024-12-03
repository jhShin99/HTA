package com.naver.myhome1.sample5_문제;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class FileOutputter implements Outputter {

    @Value("${filepath}")
    private String filePath; // 출력파일 경로와 파일이름을 저장할 변수

    public FileOutputter() {
        System.out.println("여기는 FileOutputter 생성자입니다.");
    }

    @Override
    public void output(String message) throws IOException {
        System.out.println("여기는 FileOutputter.java의 output() 입니다.");
        FileWriter out = new FileWriter(filePath);
        System.out.println("filePath=" + filePath);
        out.write(message); //메시지를 기록함
        out.close(); //출력 객체(파일)를 닫음
    }
}

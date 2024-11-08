package ex06.ex06_array;

import java.util.Scanner;

public class ArrayTest06_String {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"홍길동", "전우치", "홍길동", "세종대왕", "김길동"};
        System.out.println("검색할 이름을 입력하세요?");
        System.out.print("이름: ");
        String inputname = sc.next();
        boolean isContain = false;
        for (int i = 0; i < names.length; i++) {
            if (inputname.equals(names[i])) {
                System.out.println(inputname + "는(은) 배열의 인덱스 " + i + "에서 찾았습니다.");
                isContain = true;
                break;
            }
        }

        if (!isContain) {
            System.out.println(inputname + "는(은) 배열방에서 찾지 못했습니다.");
        }

    }
}

package ex15.ex15_stack;

import java.util.Stack;

public class Stack_Generics {

    public static void main(String[] args) {
        //Stack 객체 생성
        Stack<String> s = new Stack<>();
        System.out.println("비었나요? " + s.empty()); // true - 비었는지 판단

        // Stack에 값을 넣음
        s.push("좋아요");
        s.push("자바");

        System.out.println("비었나요? " + s.empty()); // false: 비었는지 판단

        // 스택에서 객체를 제거하지 않고 접근합니다.
        System.out.println("맨 마지막 데이터 : " + s.peek());

        // Stack의 값을 출력
        while (!s.empty()) {
            System.out.println("데이터 출력 : " + s.pop()); // 스택의 맨 위에 있는 객체를 제거합니다.
            System.out.println("남은 데이터 개수 : " + s.size());
        }

        System.out.println("비었나요? " + s.empty()); // true - 비었는지 판단ㅌ
    }
}

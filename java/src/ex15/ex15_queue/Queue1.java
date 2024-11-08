package ex15.ex15_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue1 {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        System.out.println("비었나요? " + queue.isEmpty()); //true - 비었는지 판단

        // offer() 메서드 : 큐에 3개의 데이터를 추가
        queue.offer("토끼");
        queue.offer("사슴");
        queue.offer("호랑이");

        //peek() 메서드 : 처음 데이터를 그대로 둔 상태로 가져옵니다.
        System.out.println(queue.peek());
        System.out.println("비었나요? " + queue.isEmpty()); //false-비었는지 판단
        System.out.println("개수 = " + queue.size());

        System.out.println("poll() 사용");
        while (!queue.isEmpty()) {
            //poll() 메서드는 큐에 있는 데이터를 제거하면서 가져옵니다.
            String str = queue.poll();
            System.out.println(str);
        }

        System.out.println("비었나요? " + queue.isEmpty()); // true - 비었는지 판단
    }
}

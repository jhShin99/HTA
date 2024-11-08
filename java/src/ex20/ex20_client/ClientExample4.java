package ex20.ex20_client;

import ex20.ex20_server.SenderThread;
import ex20.ex20_server.ReceiverThread;

import java.net.Socket;

public class ClientExample4 {
    public static void main(String[] args) {
        //args 파라미터로 대화명을 받습니다.
        if (args.length != 1) {
            System.out.println("대화명을 입력하세요");
            return;
        }

        try {
            System.out.println("================================");
            System.out.println("나의 대화명은 " + args[0] + "입니다."); // 파라미터에 닉네임 입력
            System.out.println("================================");
            //서버와 연결을 맺습니다.
            Socket socket = new Socket("127.0.0.1", 9002);

            //메시지 송신 스레드 생성
            Thread thread1 = new SenderThread(socket, args[0]);

            //메시지 수신 스레드 설정
            Thread thread2 = new ReceiverThread(socket);

            //스레드 시작
            thread1.start();
            thread2.start();
        } catch (Exception e) {

        }
    }
}

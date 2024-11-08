package ex20.ex20_client;

import ex20.ex20_server.SenderThread;
import ex20.ex20_server.ReceiverThread;

import java.net.Socket;

public class ClientExample3 {

    public static void main(String[] args) {
        System.out.println("여기는 클라이언트 입니다.~");
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 9002);
            //두 개의 스레드를 생성합니다.
            Thread thread2 = new ReceiverThread(socket);
            Thread thread1 = new SenderThread(socket);
            //두 개의 스레드를 시작합니다.
            thread1.start();
            thread2.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //socket 닫으면 안됩니다.
    }
}

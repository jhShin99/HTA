package ex20.ex20_server;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample4 {

    public static void main(String[] args) {
        System.out.println("여기는 서버 입니다.~");
        ServerSocket serverSocket = null;
        try {
            // 이 문장을 while문에 넣지 않도록 조심해 주세요. 서버 소켓은 한개 만들어서 사용합니다.
            serverSocket = new ServerSocket(9002);

            while (true) {
                //연결 요청이 오면 소켓을 생성합니다.
                //accept 메소드 : 서버 소켓으로 연결 요청이 들어오면 연결을 맺고
                //클라이언트 소켓을 생성해서 리턴하는 메소드
                Socket socket = serverSocket.accept();

                //요청이 올 때마다 스레드 생성
                Thread thread = new PerClientThread(socket);
                thread.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

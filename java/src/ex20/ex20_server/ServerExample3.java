package ex20.ex20_server;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample3 {

    public static void main(String[] args) {
        System.out.println("여기는 서버 입니다.~");
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(9002);
            socket = serverSocket.accept();
            System.out.println("========== 접속정보 ==========");
            System.out.println(socket.getInetAddress().getHostAddress() + "에서 접속하였습니다.");
            System.out.println("=============================");

            //두 스레드를 생성합니다.
            Thread thread1 = new SenderThreadForEx3(socket);
            Thread thread2 = new ReceiverThread(socket);

            //두 스레드를 시작합니다.
            thread1.start();
            thread2.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            /**
             * SenderThread, ReceiverThread에서 사용하는 socket을 닫아주면 안됩니다.
             * try {
             *      socket.close();
             * } catch (Exception ignored) {
             *      System.out.println("소켓 닫는 중 오류");
             * }
             */
            try {
                serverSocket.close();
            } catch (Exception ignored) {
                System.out.println("서버 소켓 닫는 중 에러 발생했습니다.");
            }
        }
    }
}


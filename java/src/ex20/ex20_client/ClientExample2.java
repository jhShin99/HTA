package ex20.ex20_client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientExample2 {
    public static void main(String[] args) {
        System.out.println("여기는 클라이언트입니다.~");
        Socket socket = null;
        try {
            /**
             * InputStreamReader 클래스:
             *  바이트 스트림을 문자 스트림으로 바꾸어주는 클래스
             *  이 클래스의 생성자에 소켓으로 얻은 InputStream 객체를 넘겨 주면
             *  네트워크로 수신된 데이터를 문자 스트림 형태로 읽을 수 있는
             *  InputStreamReader 객체가 생성됩니다.
             */
            socket = new Socket("127.0.0.1", 9001);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            //데이터를 송신합니다.
            //println 메소드 호출 즉시 네트워크로 송신되는 것이 아니라 버퍼가 다 찰때까지 모아졌다가 한꺼번에 송신됩니다.
            //그렇기 때문에 println 메소드를 호출한 다음에 바로 문자열이 송신되도록 하려면 flush 메소드를 호출해야 합니다.
            writer.println("Hello, Server2");
            writer.flush();

            //데이터를 수신합니다.
            String str = reader.readLine();
            //수신된 데이터를 출력합니다.
            System.out.println(str);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (Exception ignored) {
                System.out.println("소켓 닫는 중 오류");
            }
            try {
            } catch (Exception ignored) {
                System.out.println("서버 소켓 닫는 중 오류");
            }
        }
    }
}

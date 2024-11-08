package ex20.ex20_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerClientThread extends Thread {

    private static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());

    private Socket socket;
    private PrintWriter writer;

    public PerClientThread(Socket socket) {
        this.socket = socket;
        try {
            writer = new PrintWriter(socket.getOutputStream());
            list.add(writer); // 리스트에 소켓의 출력 스트림을 등록합니다.
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        String name = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            /**
             * SenderThread.java에서
             * writer.println(name);
             * writer.flush();
             * 로 보낸 name을 아래의 문장에서 읽어옵니다.
             */
            //수신된 첫번째 문자열을 대화명으로 사용하기 위해 저장합니다.
            name = reader.readLine();
            sendAll("#" + name + "님이 들어오셨습니다");

            while (!socket.isClosed()) {
                String str = reader.readLine();

                //소켓의 연결이 끊어지면 null을 리턴합니다.
                if (str == null)
                    break;

                //수신된 메시지 앞에 대화명을 붙여서 모든 클라이언트로 송신합니다.
                sendAll(name + ">" + str);

            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            // ?
            //사용자가 채팅을 종료했다는 메시지를 모든 클라이언트로 보냅니다.
            sendAll("#" + name + "님이 나가셨습니다");

            try {
                reader.close();
            }catch (Exception ignored) {
                System.out.println("소켓 닫는 중에 에러 발생했습니다.");
            }
        }
    }

    //서버에 연결된 모든 클라이언트로 똑같은 메시지를 보냅니다.
    synchronized private void sendAll(String str) {
        for (PrintWriter writer : list) {
            if (this.writer != writer) { //if문 추가시, 자신에게 보내지 않습니다.
                writer.println(str);
                writer.flush();
            }
        }
        System.out.println(str); //추가한 부분-서버 화면에 출력되도록 합니다.
    }
}

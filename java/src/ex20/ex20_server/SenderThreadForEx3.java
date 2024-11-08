package ex20.ex20_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SenderThreadForEx3 extends Thread{
    private Socket socket;

    public SenderThreadForEx3(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        PrintWriter writer = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(socket.getOutputStream());

            while (!socket.isClosed()) {
                //키보드로부터 문자열을 입력받습니다.
                String str = reader.readLine();

                //사용자가 "bye"라고 입력하면 반복문을 빠져나갑니다.
                if (str.equals("bye"))
                    break;

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}

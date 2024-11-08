package ex11.ex11_string;

public class StringExample9 {

    public static void main(String[] args) {
        String message = "Java program .... Chrome";

        int index1 = message.indexOf("Chrome");

        if (index1 != -1) {
            System.out.println("크롬브라우저입니다.");
        } else {
            System.out.println("크롬브라우저가 아닙니다.");
        }
    }
}

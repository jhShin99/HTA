package ex11.ex11_string;

public class Zumin2 {

    public static void main(String[] args) {
        String zumin = "123456-4123456";
        char ch = zumin.charAt(7);
        String message = "추출한 숫자는 " + ch + "이고 ";
        if (ch == '1' || ch == '3')
            message += "남자입니다.";
        else if (ch == '2' || ch == '4')
            message += "여자입니다.";
        else
            message += "외국인입니다.";

        System.out.println(message);
    }
}

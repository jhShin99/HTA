package ex11.ex11_string;

public class Zumin {

    public static void main(String[] args) {
        String zumin = "123456-4123456";
        String s = zumin.substring(7, 8);

        String message = "추출한 숫자는 " + s + "이고 ";

        if (s.equals("1") || s.equals("3")) {
            message += "남자입니다.";
        } else if (s.equals("2") || s.equals("4")) {
            message += "여자입니다.";
        } else {
            message += "외국인입니다.";
        }

        System.out.println(message);
    }
}

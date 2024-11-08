package ex11.ex11_string;

public class Zumin3 {

    boolean checkLength(String zumin) {
        if (zumin.length() == 14)
            return true;
        else
            return false;
    }

    String getGender(String zumin) {
        String num = zumin.substring(7, 8);
        String gender = "";
        switch (num) {
            case "1", "3":
                gender = "남자";
                break;
            case "2", "4":
                gender = "여자";
                break;
            default:
                gender = "외국인";
        }
        return gender;
    }

    // 과제 풀이
    public static boolean isNumber(String str) {
        if (str == null || str.equals(""))
            return false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch < '0' || ch > '9')
                return false;
        }
        return true;
    }
}

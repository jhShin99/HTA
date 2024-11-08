package ex11.ex11_string;

public class StringExample_method {

    public static boolean checkLength(String zumin) {
        return zumin.length() != 14 ? false : true;
    }

    public static String getGender(String zumin) {
        return
                switch (zumin.substring(7,8)) {
                    case "1", "3" -> "남자";
                    case "2", "4" -> "여자";
                    default       -> "외국인";
                };
    }

    public static void main(String[] args) {
        String zumin = "123456-3890123";

        genderCheck("123456-3890123");
        genderCheck("123456-4890123");
        genderCheck("123456-7890123");
        genderCheck("123456-789012");

    }

    private static void genderCheck(String zumin) {
        if (checkLength(zumin)) {
            System.out.println(getGender(zumin) + "입니다.");
        } else {
            System.out.println("주민등록번호는 14자리입니다.");
        }
    }
}

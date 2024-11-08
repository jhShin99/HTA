package ex11.ex11_string;

public class StringExample6 {

    public static void main(String[] args) {
        String str = "나를 사랑하는 자바";
        int size = str.length();
        for (int cnt = 0; cnt < size; cnt++) {
            char ch = str.charAt(cnt);
            System.out.println("index = " + cnt + " 문자 = " + ch);
        }

        System.out.println(str.substring(3));
        System.out.println(str.substring(3,6));
    }
}

package ex11.ex11_stringtokenizer;

import java.util.StringTokenizer;

public class StringTokenizerExample3 {

    public static void main(String[] args) {
        System.out.println("===== 구분자   :   공백 =====");
        StringTokenizer stok = new StringTokenizer("사과,배,복숭아", ",");

        while(stok.hasMoreTokens()) { // 토큰이 있는동안 반복해라
            String str = stok.nextToken(); // 문자열로부터 토큰을 추출
            System.out.println(str);
        }

    }
}

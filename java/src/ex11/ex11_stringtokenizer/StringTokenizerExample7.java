package ex11.ex11_stringtokenizer;


import java.util.StringTokenizer;

/**
 * StringTokenizer의 기능
 * StringTokenizer의 기능과 유사한 String의 split메서드 사용법
 *
 * StringTokenizer : 010-1234-5678 토큰 분리
 * 010
 * 1234
 * 5678
 * String의 split 메서드 이용 : 010-1234-5678 토큰 분리
 * 010
 * 1234
 * 5678
 */
public class StringTokenizerExample7 {

    public static void main(String[] args) {
        String phone = "010-1234-5678";
        StringTokenizer str = new StringTokenizer(phone, "-");
        System.out.println("*** StringTokenizer : " + phone + " 토큰 분리 ***");
        while (str.hasMoreTokens()) {
            System.out.println(str.nextToken());
        }

        System.out.println("***String의 split 메서드 이용 : " + phone + " 토큰 분리***");
        String[] st = phone.split("-");

        // 배열의 개수가 가변적일때 length 속성을 이용한다.
        for (int i = 0; i < st.length; i++) {
            System.out.println(st[i]);
        }
        System.out.println("========== 향상된 for문 ==========");
        for (String num : st) {
            System.out.println(num);
        }
    }
}

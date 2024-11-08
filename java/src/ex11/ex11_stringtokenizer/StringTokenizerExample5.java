package ex11.ex11_stringtokenizer;

import java.util.StringTokenizer;

public class StringTokenizerExample5 {

    public static void main(String[] args) {
        StringTokenizer stok = new StringTokenizer("사과=10|초콜릿=3|샴페인=1", "=|", true);

        while(stok.hasMoreTokens()) {
            String str = stok.nextToken();
            System.out.println(str);
        }
    }
}

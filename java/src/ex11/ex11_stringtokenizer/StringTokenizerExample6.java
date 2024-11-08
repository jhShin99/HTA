package ex11.ex11_stringtokenizer;

import java.util.StringTokenizer;

public class StringTokenizerExample6 {
    public static void main(String[] args) {
        StringTokenizer stok = new StringTokenizer("사과=10|초콜릿=3|샴페인=1", "=|", true);

        System.out.println("상품이름\t상품 수");
        while (stok.hasMoreTokens()) {
            String token = stok.nextToken();
            if (token.equals("=")) {
                System.out.print("\t");
            } else if (token.equals("|")) {
                System.out.print("\n");
            } else {
                System.out.print(token);
            }
        }
    }
}

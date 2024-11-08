package ex.step10_select_statement_try_with_resources;

import java.sql.*;

public class JDBCExample3_Oracle {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String select_sql = "select code, name, price, maker from goodsinfo where name = ?";

        try (
                Connection conn = DriverManager.getConnection(url, "scott", "tiger");
                PreparedStatement pstmt = conn.prepareStatement(select_sql);
        ) {

            // 이 문장을 주석으로 처리하면 에러 - 인덱스에서 누락된 IN 또는 OUT 매개변수: 1
            pstmt.setString(1, "디지털 TV");

            try (ResultSet rs = pstmt.executeQuery();) {
                System.out.println("번호\t상품코드\t상품명\t\t가격\t제조사");
                System.out.println("--------------------------------------------------------------------------");
                int i = 0;
                while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복
                    //getString("code") : 컬럼 code 값을 String 형으로 리턴하는 메소드
                    String code = rs.getString("code");
                    String name = rs.getString("name");

                    //getInt("price") : 컬럼 price 값을 int 형으로 리턴하는 메소드
                    int price = rs.getInt("price");

                    String maker = rs.getString("maker");

                    System.out.printf("%d\t%-7s\t%-10s\t%d\t%-5s\n", ++i, code, name, price, maker);
                }
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }
}

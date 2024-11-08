package ex.step8_prepared_statement;

import java.sql.*;
import java.util.Scanner;

public class JDBCExample5_Oracle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("상품명을 입력하세요>"); //디지털 TV
        String search = sc.nextLine();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "scott", "tiger");

            String select_sql = "select code, name, price, maker from goodsinfo where name = ?";

            pstmt = conn.prepareStatement(select_sql);
            System.out.println(select_sql);
            pstmt.setString(1, search);
            rs = pstmt.executeQuery();

            System.out.println("번호\t상품코드\t상품명\t\t가격\t제조사");
            System.out.println("--------------------------------------------------------------------------");

            int i = 0;
            while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복
                //getString("code") : 컬럼 code 값을 String 형으로 리턴하는 메소드
                String code =rs.getString("code");
                String name = rs.getString("name");
                //getInt("price") : 컬럼 price 값을 int 형으로 리턴하는 메소드
                int price = rs.getInt("price");
                String maker = rs.getString("maker");

                System.out.printf("%d\t%-7s\t%-10s\t%d\t%-5s\n", ++i, code, name, price, maker);
            }
        } catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close(); // 4단계: DB연결을 끊는다.
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

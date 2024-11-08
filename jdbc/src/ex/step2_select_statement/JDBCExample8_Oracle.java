package ex.step2_select_statement;

import java.sql.*;
import java.util.Scanner;

public class JDBCExample8_Oracle {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("검색어를 입력하세요> ");
        String search = sc.nextLine();

        try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "scott", "tiger");

            stmt = conn.createStatement();

            String select_sql = "select code, name, price, maker from goodsinfo where name = \'" + search + "\'";
            rs = stmt.executeQuery(select_sql);


            System.out.printf("%-4s %-10s %-20s %-10s %-10s\n", "번호", "상품코드", "상품명", "가격", "제조사");
            System.out.println("--------------------------------------------------------------------------");

            int i = 0;
            while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복
                //getString("code") : 컬럼 code 값을 String 형으로 리턴하는 메소드
                String code =rs.getString("code");
                String name = rs.getString("name");

                //getInt("price") : 컬럼 price 값을 int 형으로 리턴하는 메소드
                int price = rs.getInt("price");

                String maker = rs.getString("maker");

                System.out.printf("%-4d %-10s %-20s %-10d %-10s\n", ++i, code, name, price, maker);
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
            if (stmt != null) {
                try {
                    stmt.close();
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

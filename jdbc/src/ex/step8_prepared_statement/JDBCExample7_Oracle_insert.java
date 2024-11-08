package ex.step8_prepared_statement;

import java.sql.*;

//데이터베이스의 테이블에 데이터를 추가하는 프로그램
public class JDBCExample7_Oracle_insert {

    public static void main(String[] args) {
        //"A6000" "무선청소기" 500 "LG"
        if (args.length != 4) {
            System.out.println("상품코드 상품명 가격 제조사를 입력하세요");
            return;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "scott", "tiger");

            String sql = "insert into goodsinfo(code, name, price, maker) values (?,?,?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, args[0]);
            pstmt.setString(2, args[1]);
            pstmt.setInt(3, Integer.parseInt(args[2]));
            pstmt.setString(4, args[3]);
            int rowNum = pstmt.executeUpdate();

            System.out.println(rowNum + "행이 추가되었습니다.");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            se.printStackTrace();
        } finally {
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

package ex.step8_prepared_statement;

import java.sql.*;

//데이터베이스의 테이블에 데이터를 수정하는 프로그램
public class JDBCExample9_Oracle_update {
    public static void main(String[] args) {
        if (args.length != 2) { //"10001" "LG" -> "10001" "HTA"
            System.out.println("상품코드, 제조사 입력하세요");
            return;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "scott", "tiger");

            String upd_sql = "update goodsinfo set maker = ? where code = ?";
            pstmt = conn.prepareStatement(upd_sql);

            pstmt.setString(1, args[1]); //"HTA"
            pstmt.setString(2, args[0]); //"10001"
            int rowNum = pstmt.executeUpdate();
            System.out.println(rowNum + "행이 수정되었습니다.");
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

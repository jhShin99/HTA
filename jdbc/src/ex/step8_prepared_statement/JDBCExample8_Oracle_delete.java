package ex.step8_prepared_statement;

import java.sql.*;

//데이터베이스의 테이블에 데이터를 삭제하는 프로그램
public class JDBCExample8_Oracle_delete {
    public static void main(String[] args) {
        //A5000
        if (args.length != 1) {
            System.out.println("상품코드 입력하세요");
            return;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "scott", "tiger");

            String del_sql = "delete from goodsinfo where code = ?";

            pstmt = conn.prepareStatement(del_sql);
            pstmt.setString(1, args[0]);
            int rowNum = pstmt.executeUpdate();
            System.out.println(rowNum + "행이 삭제되었습니다.");
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

package ex.step5_insert_delete_update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//데이터베이스의 테이블에 데이터를 추가하는 프로그램
public class JDBCExample1_Oracle_insert {

    public static void main(String[] args) {
        //"A2000" "모니터" 200 "삼성"
        if (args.length != 4) {
            System.out.println("상품코드 상품명 가격 제조사를 입력하세요");
            return;
        }

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "scott", "tiger");
            stmt = conn.createStatement();

            String sql = "insert into goodsinfo values('" + args[0] + "', '" + args[1] + "', " + args[2] + ", '" + args[3] + "')";
            System.out.println(sql);

            int rowNum = stmt.executeUpdate(sql);
            System.out.println(rowNum + "행이 추가되었습니다.");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            se.printStackTrace();
        } finally {
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

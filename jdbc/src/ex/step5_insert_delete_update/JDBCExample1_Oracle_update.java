package ex.step5_insert_delete_update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//데이터베이스의 테이블에 데이터를 삭제하는 프로그램
public class JDBCExample1_Oracle_update {
    public static void main(String[] args) {
        if (args.length != 2) { //10004 아이리버 -> 10004 오라클
            System.out.println("상품코드, 제조사 입력하세요");
            return;
        }

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "scott", "tiger");
            stmt = conn.createStatement();

            //delete from goodsinfo where code = 'args[0]의 값'
            String single = "'";

            //10004 오라클
            String upd_sql
            = "update goodsinfo set maker = "
            + single + args[1] + single
            + " where code =  " + single + args[0] + single;
            System.out.println(upd_sql);
            int rowNum = stmt.executeUpdate(upd_sql);
            System.out.println(rowNum + "행이 수정되었습니다.");
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

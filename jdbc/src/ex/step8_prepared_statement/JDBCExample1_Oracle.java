package ex.step8_prepared_statement;

import java.sql.*;

public class JDBCExample1_Oracle {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            //1단계 : JDBC 드라이버를 로드한다.
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);

            //2단계 : DB에 연결한다.
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "scott", "tiger");

            String select_sql = "select * from dept";

            //PreparedStatement 객체 얻기
            pstmt = conn.prepareStatement(select_sql);
            rs = pstmt.executeQuery();

            System.out.println("번호\t부서번호\t부서명\t지역");
            System.out.println("--------------------------------------------------------------------");

            int i = 0;
            while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복
                int deptno = rs.getInt("deptno"); //조회시 두번째 컬럼을 가져옵니다.
                String dname = rs.getString("dname"); //조회시 세번째 컬럼을 가져옵니다.
                String loc = rs.getString("loc"); //조회시 첫번째 컬럼을 가져옵니다.

                System.out.printf("%5d\t%5d\t%-15s%s\n", ++i, deptno, dname, loc);

            }
        } catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스를 찾을 수 없습니다. " + cnfe.getMessage());
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

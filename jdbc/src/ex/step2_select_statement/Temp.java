package ex.step2_select_statement;

import java.sql.*;

public class Temp {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "scott", "tiger");

            stmt = conn.createStatement();

            String select_sql = "select d.dname 부서이름, e.ename 사원이름, e.deptno 부서번호, e.sal 급여\n" +
                    "from emp e, dept d where e.DEPTNO = d.DEPTNO order by d.dname";

            rs = stmt.executeQuery(select_sql);
            int i = 0;

            System.out.println("번호  부서이름  사원이름  부서번호 급여");
            System.out.println("----------------------------------");

            while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복
                String dname = rs.getString("부서이름");
                String ename = rs.getString("사원이름");
                int deptno = rs.getInt("부서번호");
                int sal = rs.getInt("급여");

                System.out.printf("%d\t%s\t%s\t%d\t%d\n", ++i, dname, ename, deptno, sal);
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

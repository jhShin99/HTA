package ex.step2_select_statement;

import java.sql.*;

public class JDBCExample3_Oracle {

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

            String select_sql = "select * from emp";

            rs = stmt.executeQuery(select_sql);
            int i = 0;

            System.out.println("번호  사원번호  사원이름   직급       상사    입사일       급여   커미션   부서번호");
            System.out.println("--------------------------------------------------------------------------");

            while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                int mgr = rs.getInt("mgr");
                //Date hiredate = rs.getDate("hiredate"); //1980-12-17
                String hiredate = rs.getString("hiredate").substring(0,10); //1980-12-17
                //String hiredate = rs.getString("hiredate"); //1980-12-17 00:00:00
                int sal = rs.getInt("sal");
                int comm = rs.getInt("comm");
                int deptno = rs.getInt("deptno");

                System.out.printf("%-5d%-8d%-10s%-10s%-8d%-12s%-8d%-8d%-8d\n", ++i, empno, ename, job, mgr, hiredate, sal, comm, deptno);
                System.out.println();
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

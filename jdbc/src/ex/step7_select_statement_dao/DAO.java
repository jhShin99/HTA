package ex.step7_select_statement_dao;

import java.sql.*;
import java.util.ArrayList;

public class DAO {


    public ArrayList<Emp> search(int col_index, String search_word) {

        ArrayList<Emp> list = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String[] column_name = {"empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno"};
        String sql = "select * from emp";

        if (col_index != 8) { // 8은 종료를 의미

            String single = "";
            // ename, job, hiredate 는 ' 필요
            if (col_index == 1 || col_index == 2 || col_index == 4)
                single = "'";

            sql = sql + " where " + column_name[col_index] + "=" + single + search_word + single;
        }
        System.out.println("\n" + sql.toString() + "\n");


        try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "scott", "tiger");

            stmt = conn.createStatement();

            String select_sql = "select * from emp where " + column_name[col_index] + " = " + "'" + search_word + "'";

            rs = stmt.executeQuery(select_sql);


            while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복
                Emp st = new Emp();
                st.setEmpno(rs.getInt("empno"));
                st.setEname(rs.getString("ename"));
                st.setJob(rs.getString("job"));
                st.setMgr(rs.getInt("mgr"));
                st.setHiredate(rs.getDate("hiredate"));
                st.setSal(rs.getInt("sal"));
                st.setComm(rs.getInt("comm"));
                st.setDeptno(rs.getInt("deptno"));
                list.add(st);
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

        return list;
    }

    public ArrayList<Emp> selectAll() {
        ArrayList<Emp> list = new ArrayList<>();

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


            while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복
                Emp st = new Emp();
                st.setEmpno(rs.getInt("empno"));
                st.setEname(rs.getString("ename"));
                st.setJob(rs.getString("job"));
                st.setMgr(rs.getInt("mgr"));
                st.setHiredate(rs.getDate("hiredate"));
                st.setSal(rs.getInt("sal"));
                st.setComm(rs.getInt("comm"));
                st.setDeptno(rs.getInt("deptno"));
                list.add(st);
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
        return list;
    }
}

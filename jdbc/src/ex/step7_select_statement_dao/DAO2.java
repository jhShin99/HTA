package ex.step7_select_statement_dao;

import java.sql.*;
import java.util.ArrayList;

public class DAO2 {
    public ArrayList<Emp> search(String[] searchs) {

        ArrayList<Emp> list = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String[] column_name = {"empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno"};

        String sql = "select * from emp";

        //empno, mgr, sal, comm, deptno는 '없어도 됨
        for (int i = 0; i < searchs.length; i++) {
            if (searchs[i] != null) {
                String single = "";
                if (i == 1 || i == 2 || i == 4) // ename, job, hiredate는 ' 필요
                    single = "'";

                if (sql.contains("where")) //where이 포함되어 있는지 확인
                    sql += " and ";
                else
                    sql += " where ";

                sql += column_name[i] + "=" + single + searchs[i] + single;
            }
        }
        System.out.println(sql);

        try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "scott", "tiger");

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);


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

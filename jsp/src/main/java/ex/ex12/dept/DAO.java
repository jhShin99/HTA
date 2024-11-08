package ex.ex12.dept;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * DAO(Data Access Object) 클래스
 * - 데이터 베이스와 연동하여 레코드의 추가, 수정, 삭제 작업이 이루어지는 클래스 입니다.
 */
public class DAO {
    private DataSource ds;

    //생성자에서 JNDI 리소스를 참조하여 Connection 객체를 가져올 수 있는 DataSource를 구합니다.
    public DAO() {
        try {
            Context init = new InitialContext();
            ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
        } catch (Exception ex) {
            System.out.println("DB 연결 실패 : " + ex);
        }
    }

    public ArrayList<Dept> selectAll() {
        ArrayList<Dept> list = new ArrayList<>();
        String select_sql = "select * from dept";
        try (
                Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(select_sql);
        ) {
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복
                    int deptno = rs.getInt("deptno");
                    String dname = rs.getString("dname");
                    String loc = rs.getString("loc");
                    Dept dept = new Dept();
                    dept.setDeptno(deptno);
                    dept.setDname(dname);
                    dept.setLoc(loc);
                    list.add(dept);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    } //selectAll end

    public ArrayList<Dept> select(int inputDeptno) {
        ArrayList<Dept> list = new ArrayList<>();
        String select_sql = "select * from dept where deptno = ?";

        try (
                Connection conn = ds.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(select_sql);
        ) {
            pstmt.setInt(1, inputDeptno);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복
                    int deptno = rs.getInt("deptno");
                    String dname = rs.getString("dname");
                    String loc = rs.getString("loc");
                    Dept dept = new Dept();
                    dept.setDeptno(deptno);
                    dept.setDname(dname);
                    dept.setLoc(loc);
                    list.add(dept);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
} //class end

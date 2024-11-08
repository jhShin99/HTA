package ex.ex12.emp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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

    public ArrayList<Emp> selectAll() {
        ArrayList<Emp> list = new ArrayList<>();
        String select_sql = "select * from emp";
        try (
                Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(select_sql);
        ) {
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복

                    int empno = rs.getInt("empno");
                    String ename = rs.getString("ename");
                    String job = rs.getString("job");
                    int mgr = rs.getInt("mgr");
                    Date hiredate = rs.getDate("hiredate");
                    int sal = rs.getInt("sal");
                    int comm = rs.getInt("comm");
                    int deptno = rs.getInt("deptno");

                    Emp emp = new Emp();
                    emp.setEmpno(empno);
                    emp.setEname(ename);
                    emp.setJob(job);
                    emp.setMgr(mgr);
                    emp.setHiredate(hiredate);
                    emp.setSal(sal);
                    emp.setComm(comm);
                    emp.setDeptno(deptno);

                    list.add(emp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    } //selectAll end
} //class end

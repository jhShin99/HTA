package ex.ex2.step1.dept;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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

    public JsonArray getList_lib() {
        String sql = """
                select *
                from dept
                order by deptno
                """;
        JsonArray array = new JsonArray();
        try (
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    JsonObject obj = new JsonObject();
                    obj.addProperty("deptno", rs.getInt("deptno"));
                    obj.addProperty("dname", rs.getString("dname"));
                    obj.addProperty("loc", rs.getString("loc"));
                    array.add(obj);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    public JsonArray getList_lib_search(int deptno) {
        String sql = """
                select *
                from dept
                where deptno = ?
                """;

        JsonArray array = new JsonArray();
        try (
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setInt(1, deptno);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    JsonObject obj = new JsonObject();
                    obj.addProperty("deptno", rs.getInt("deptno"));
                    obj.addProperty("dname", rs.getString("dname"));
                    obj.addProperty("loc", rs.getString("loc"));
                    array.add(obj);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }
} //class end

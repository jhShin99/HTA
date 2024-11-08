package ex.ex2.step2.product;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public JsonArray getList() {
        JsonArray array = new JsonArray();
        String sql = """
                select *
                from products
                order by id
                """;
        //데이터 베이스 작업에 필요한 인터페이스들의 레퍼런스 변수를 선언합니다.
        try (
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    JsonObject obj = new JsonObject();
                    obj.addProperty("id", rs.getInt("id"));
                    obj.addProperty("name", rs.getString("name"));
                    obj.addProperty("price", rs.getInt("price"));
                    obj.addProperty("maker", rs.getString("maker"));
                    array.add(obj);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    public int insert(DTO vo) {
        String sql = """
                insert into products
                values((select nvl(max(id),0)+1 from PRODUCTS), ?, ?, ?)
                """;
        int result = 0;
        try (
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1, vo.getName());
            pstmt.setInt(2, vo.getPrice());
            pstmt.setString(3, vo.getMaker());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(int id) {
        String sql = """
                delete from products
                where id = ?
                """;
        int result = 0; //초기값
        try (
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setInt(1, id);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(DTO vo) {
        String sql = """
                update products
                set name=?, price=?, maker=?
                where id=?
                """;
        int result = 0;
        try (
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1, vo.getName());
            pstmt.setInt(2, vo.getPrice());
            pstmt.setString(3, vo.getMaker());
            pstmt.setInt(4, vo.getId());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

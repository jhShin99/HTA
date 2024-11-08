package net.template.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
    //context.xml 설정파일, ojdbc6 있나 확인
    private DataSource ds;

    public DAO() {
        try {
            Context init = new InitialContext();
            ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
        } catch (Exception ex) {
            System.out.println("DB 연결 실패 : " + ex);
        }
    }

    public int isId(String id) {
        return isId(id, null);
    }

    public int isId(String id, String password) {
        int result = 0; // 아이디가 존재하지 않는 경우
        String select_sql = """
                select id, password
                from template_join
                where id = ?
                """;

        try (
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(select_sql);
        ) {
            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    if (rs.getString("password").equals(password)) {
                        return 1; //아이디와 비밀번호가 일치하는 경우
                    } else {
                        result = -1; //아이디는 일치하고 비밀번호가 일치하지 않는 경우
                    }
                } // if (rs.next())
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    } //isId()

    public int insert(TemplateJoin templateJoin) {
        int result = 0;
        String insert_sql = """
                insert into template_join
                (id, password, jumin, email, gender, hobby, post, address, intro)
                values (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(insert_sql);
        ) {
            pstmt.setString(1, templateJoin.getId());
            pstmt.setString(2, templateJoin.getPassword());
            pstmt.setString(3, templateJoin.getJumin());
            pstmt.setString(4, templateJoin.getEmail());
            pstmt.setString(5, templateJoin.getGender());
            pstmt.setString(6, templateJoin.getHobby());
            pstmt.setString(7, templateJoin.getPost());
            pstmt.setString(8, templateJoin.getAddress());
            pstmt.setString(9, templateJoin.getIntro());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public TemplateJoin selectInfo(String id) {
        String select_sql = "select * from template_join where id = ?";

        try (
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(select_sql);
        ) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    TemplateJoin temp = new TemplateJoin();
                    temp.setId(rs.getString("id"));
                    temp.setPassword(rs.getString("password"));
                    temp.setJumin(rs.getString("jumin"));
                    temp.setEmail(rs.getString("email"));
                    temp.setGender(rs.getString("gender"));
                    temp.setHobby(rs.getString("hobby"));
                    temp.setPost(rs.getString("post"));
                    temp.setAddress(rs.getString("address"));
                    temp.setIntro(rs.getString("intro"));
                    temp.setRegister_date(rs.getString("register_date"));
                    return temp;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int update(TemplateJoin join) {
        int result = 0;
        String sql = """
                update template_join
                set password=?, jumin=?, email=?, gender=?, hobby=?,
                    post=?, address=?, intro=?
                    where id = ?
                """;
        try (
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ) {
            pstmt.setString(1, join.getPassword());
            pstmt.setString(2, join.getJumin());
            pstmt.setString(3, join.getEmail());
            pstmt.setString(4, join.getGender());
            pstmt.setString(5, join.getHobby());
            pstmt.setString(6, join.getPost());
            pstmt.setString(7, join.getAddress());
            pstmt.setString(8, join.getIntro());
            pstmt.setString(9, join.getId());
            result = pstmt.executeUpdate();
        } catch (Exception se) {
            se.printStackTrace();
        }
        return result;
    }

    public ArrayList<TemplateJoin> selectAll() {
        ArrayList<TemplateJoin> list = new ArrayList<>();
        String select_sql = """
                select * from template_join
                where id != 'admin'
                order by register_date desc
                """;
        try (
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(select_sql);
        ) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    TemplateJoin temp = new TemplateJoin();
                    temp.setId(rs.getString("id"));
//                    temp.setPassword(rs.getString("password"));
//                    temp.setJumin(rs.getString("jumin"));
//                    temp.setEmail(rs.getString("email"));
                    temp.setGender(rs.getString("gender"));
                    temp.setHobby(rs.getString("hobby"));
//                    temp.setPost(rs.getString("post"));
//                    temp.setAddress(rs.getString("address"));
                    temp.setIntro(rs.getString("intro"));
                    temp.setRegister_date(rs.getString("register_date"));
                    list.add(temp);
                }
            }
        } catch (Exception se) {
            se.printStackTrace();
        }
        return list;
    }

    public int delete(String id) {
        int result = 0;
        String sql = "delete from template_join where id = ?";
        try (
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1, id);
            result = pstmt.executeUpdate();
        } catch (Exception se) {
            se.printStackTrace();
        }
        return result;
    }
}


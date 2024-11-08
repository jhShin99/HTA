package net.member.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private DataSource ds;

    public MemberDAO() {
        try {
            Context init = new InitialContext();
            this.ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
        } catch (Exception ex) {
            System.out.println("DB 연결 실패 : " + ex);
        }
    }

    public int isId(String id) {
        int result = -1; //DB에 해당 id가 없습니다.
        String sql = """
                select id
                from member
                where id = ?
                """;

        try (Connection con = ds.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    result = 0; // DB에 해당 id가 있습니다.
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int isId(String id, String pass) {
        int result = -1; //아이디가 존재하지 않습니다.
        String sql = """
                select id, password
                from member
                where id = ?
                """;

        try (Connection con = ds.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    if (rs.getString("password").equals(pass)) {
                        result = 1; //아이디와 비밀번호 일치하는 경우
                    } else {
                        result = 0; //비밀번호가 일치하지 않는 경우
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int insert(Member m) {
        int result = 0;
        String sql = """
                insert into member
                (id, password, name, age, gender, email)
                values(?, ?, ?, ?, ?, ?)
                """;

        try (
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1, m.getId());
            pstmt.setString(2, m.getPassword());
            pstmt.setString(3, m.getName());
            pstmt.setInt(4, m.getAge());
            pstmt.setString(5, m.getGender());
            pstmt.setString(6, m.getEmail());
            result = pstmt.executeUpdate(); // 삽입 성공시 result는 1
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Member getMemberById(String id) {
        Member m = null;
        String sql = """
                select *
                from member
                where id = ?
                """;
        try (Connection con = ds.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    m = new Member();
                    m.setId(rs.getString("id"));
                    m.setPassword(rs.getString("password"));
                    m.setName(rs.getString("name"));
                    m.setAge(rs.getInt("age"));
                    m.setGender(rs.getString("gender"));
                    m.setEmail(rs.getString("email"));
                    m.setMemberfile(rs.getString("memberfile"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    public int update(Member m) {
        int result = 0;
        String sql = """
                update member
                set name = ?, age = ?, gender = ?, email = ?, memberfile = ?
                where id = ?
                """;
        try (
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1, m.getName());
            pstmt.setInt(2, m.getAge());
            pstmt.setString(3, m.getGender());
            pstmt.setString(4, m.getEmail());
            pstmt.setString(5, m.getMemberfile());
            pstmt.setString(6, m.getId());

            result = pstmt.executeUpdate(); // 삽입 성공시 result는 1
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Member> getList(int page, int limit) {
        List<Member> list = new ArrayList<Member>();
        String sql = """
                 select *
                 from (select b.*, rownum rnum
                       from (select * from member
                             where id != 'admin'
                             order by id) b
                       where rownum <= ?
                       )
                 where rnum >= ? and rnum <= ?
                """;

        try (Connection con = ds.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);) {
            // 한 페이지당 10개씩 목록인 경우 1페이지, 2페이지, 3페이지,
            int startrow = (page - 1) * limit + 1;         // 읽기 시작할 row 번호(1      11      21
            int endrow = startrow + limit - 1;             // 읽을 마지막 row 번호(10     20      30
            pstmt.setInt(1, endrow);
            pstmt.setInt(2, startrow);
            pstmt.setInt(3, endrow);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Member m = new Member();
                    m.setId(rs.getString("id"));
                    m.setPassword(rs.getString(2));
                    m.setName(rs.getString(3));
                    m.setAge(rs.getInt(4));
                    m.setGender(rs.getString(5));
                    m.setEmail(rs.getString(6));
                    list.add(m);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    } //getList end

    public List<Member> getList(String field, String value, int page, int limit) {
        List<Member> list = new ArrayList<Member>();
        String sql = """
                 select *
                 from (select b.*, rownum rnum
                       from (select * from member
                             where id != 'admin'
                             and %s like ?
                             order by id) b
                       where rownum <= ?
                       )
                 where rnum >= ? and rnum <= ?
                """.formatted(field);

        try (Connection con = ds.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, "%" + value + "%");

            int startrow = (page - 1) * limit + 1;         // 읽기 시작할 row 번호(1      11      21
            int endrow = startrow + limit - 1;             // 읽을 마지막 row 번호(10     20      30
            pstmt.setString(1, "%" + value + "%");
            pstmt.setInt(2, endrow);
            pstmt.setInt(3, startrow);
            pstmt.setInt(4, endrow);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Member m = new Member();
                    m.setId(rs.getString("id"));
                    m.setPassword(rs.getString(2));
                    m.setName(rs.getString(3));
                    m.setAge(rs.getInt(4));
                    m.setGender(rs.getString(5));
                    m.setEmail(rs.getString(6));
                    list.add(m);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getListCount() {
        int x = 0;
        String sql = """
                select count(*)
                from member
                where id != 'admin'
                """;
        try (Connection con = ds.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);) {
            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    x = rs.getInt(1);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("getListCount() 에러: " + ex);
        }
        return x;
    } //getListCount() end

    public int getListCount(String field, String value) {
        int x = 0;
        String sql = """
                select count(*)
                from member
                where id != 'admin'
                and %s like ?
                """.formatted(field);
        System.out.println(sql);
        try (Connection con = ds.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, "%" + value + "%"); //'%a%'
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    x = rs.getInt(1);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("getListCount() 에러: " + ex);
        }
        return x;
    } //getListCount() end

    public int delete(String id) {
        int result = 0;
        String sql = """
                delete from member
                where id = ?
                """;
        try (Connection con = ds.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, id);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

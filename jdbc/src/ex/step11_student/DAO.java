package ex.step11_student;

import java.sql.*;
import java.util.ArrayList;

public class DAO {

    public ArrayList<Student3> selectAll() {
        String sql = "select * from student order by no";

        ArrayList<Student3> list = new ArrayList<>();

        try (
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
        ) {

            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);
            System.out.println("번호\t이름\t국어\t수학\t영어\t총점\t평균\t학점");
            System.out.println("----------------------------------------");
            while (rs.next()) {
                Student3 student = new Student3();
                int no = rs.getInt("no");
                String name = rs.getString("name");
                int kor = rs.getInt("kor");
                int math = rs.getInt("math");
                int eng = rs.getInt("eng");
                int tot = rs.getInt("tot");
                float avg = rs.getFloat("avg");
                String grade = rs.getString("grade");

                student.setNo(no);
                student.setName(name);
                student.setKor(kor);
                student.setMath(math);
                student.setEng(eng);
                student.setTot(tot);
                student.setAvg(avg);
                student.setGrade(grade);

                list.add(student);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    public int delete (int no) {
        String sql = "delete from student where no = ?";
        int result = -1;
        try (
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ) {
            pstmt.setInt(1, no);
            result = pstmt.executeUpdate();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return result;
    }
    public int update(Student3 student) {

        String sql = "update student set name = ?, kor = ?, math = ?, eng = ?, tot = ?," +
                " avg = ?, grade = (select grade from hakjum where ? between lowscore and hiscore) where no = ?";
        try (
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {

            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getKor());
            pstmt.setInt(3, student.getMath());
            pstmt.setInt(4, student.getEng());
            pstmt.setInt(5, student.getTot());
            pstmt.setFloat(6, student.getAvg());
            pstmt.setFloat(7, student.getAvg());
            pstmt.setInt(8, student.getNo());

            pstmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Student3 select(int no) {
        String sql = "select * from student where no = ?";
        Student3 student = null;
        try (
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, no);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    student = new Student3();
                    student.setNo(rs.getInt("no"));
                    student.setName(rs.getString("name"));
                    student.setKor(rs.getInt("kor"));
                    student.setMath(rs.getInt("math"));
                    student.setEng(rs.getInt("eng"));
                    student.setTot(rs.getInt("tot"));
                    student.setAvg(rs.getFloat("avg"));
                    student.setGrade(rs.getString("grade"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public int insert(Student3 student) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        int rowNum = 0;
        String sql = "insert into student values (student_seq.nextval,?,?,?,?,?,?, (select grade from hakjum where ? between lowscore and hiscore))";
        try (
                Connection conn = DriverManager.getConnection(url, "scott", "tiger");
                PreparedStatement pstmt = conn.prepareStatement(sql);

        ) {
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);

            //2단계 : DB에 연결한다.

            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getKor());
            pstmt.setInt(3, student.getMath());
            pstmt.setInt(4, student.getEng());
            pstmt.setInt(5, student.getTot());
            pstmt.setDouble(6, student.getAvg());
            pstmt.setDouble(7, student.getAvg());

            rowNum = pstmt.executeUpdate();
            if (rowNum == 1) {
                System.out.println("db에 반영됨. . . . . .");
            }

        } catch (Exception e) {
            System.out.println("오류 발생");
            e.printStackTrace();
        }
        return rowNum;
    }
}

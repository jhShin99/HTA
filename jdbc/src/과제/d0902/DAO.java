package 과제.d0902;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO {

    public List<Map<String, Object>> select() {
        List<Map<String, Object>> list = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "scott", "tiger");

            stmt = conn.createStatement();

            String select_sql = "select deptno 부서번호, max(sal) 최고급여, count(empno) ||'명' 부서인원수 from emp group by deptno";

            rs = stmt.executeQuery(select_sql);


            while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복
                Map<String, Object> map = new HashMap<>();
                String deptno = rs.getString("부서번호");
                int maxSal = rs.getInt("최고급여");
                String count = rs.getString("부서인원수");
                map.put("부서번호", deptno);
                map.put("최고급여", maxSal);
                map.put("부서인원수", count);

                list.add(map);
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

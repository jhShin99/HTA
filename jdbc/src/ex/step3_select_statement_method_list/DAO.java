package ex.step3_select_statement_method_list;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {



    public List<GoodsInfo> select() {
        List<GoodsInfo> list = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "scott", "tiger");

            stmt = conn.createStatement();

            String select_sql = "select * from goodsinfo";

            rs = stmt.executeQuery(select_sql);

            GoodsInfo goodsInfo;
            while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복
                //getString("code") : 컬럼 code 값을 String 형으로 리턴하는 메소드
                String code =rs.getString("code");
                String name = rs.getString("name");

                //getInt("price") : 컬럼 price 값을 int 형으로 리턴하는 메소드
                int price = rs.getInt("price");
                String maker = rs.getString("maker");
                goodsInfo = new GoodsInfo(code, name, price, maker);
                list.add(goodsInfo);
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

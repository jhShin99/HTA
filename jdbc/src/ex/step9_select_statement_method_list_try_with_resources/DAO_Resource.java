package ex.step9_select_statement_method_list_try_with_resources;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Resource {



    public List<GoodsInfo> select() {
        List<GoodsInfo> list = new ArrayList<>();

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String select_sql = "select * from goodsinfo";

        try (
                Connection conn = DriverManager.getConnection(url, "scott", "tiger");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(select_sql);
                )
        {
            while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복
                //getString("code") : 컬럼 code 값을 String 형으로 리턴하는 메소드
                String code =rs.getString("code");
                String name = rs.getString("name");

                //getInt("price") : 컬럼 price 값을 int 형으로 리턴하는 메소드
                int price = rs.getInt("price");
                String maker = rs.getString("maker");
                GoodsInfo goodsInfo = new GoodsInfo(code, name, price, maker);
                list.add(goodsInfo);
            }

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return list;
    }
}

package ex.step10_select_statement_try_with_resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCExample10_Oracle_Prepared_Statement_Transaction {
    public static void main(String[] args) {
        /**
         * transaction : 논리적인 작업 단위
         * insert, delete, update 등의 작업들을 하나의 논리적인 작업단위로
         * 묶어서 쿼리 실행시 모든 작업이 정상 처리 된 경우에는 commit을 실행해서
         * db에 반영하고 쿼리 실행 중 하나라도 정상처리 되지 않는 경우
         * rollback을 실행해서 작업단위내의 모든 작업을 취소한다.
         */

        //SQL문 작성하기
        String sql1 = "insert into goodsinfo values(?,?,?,?)";
        String sql2 = "update goodsinfo set price = ? where code = ?";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        try (Connection conn = DriverManager.getConnection(url, "scott", "tiger")) {
            //autoCommit 기능 비활성화
            conn.setAutoCommit(false);

            // ---------- 1번 작업 시작 ---------- //
            try (PreparedStatement pstmt1 = conn.prepareStatement(sql1.toString())) {
                //쿼리의 ?에 대체될 실제값 지정하기
                pstmt1.setString(1, "10006");
                pstmt1.setString(2, "공기청정기");
                pstmt1.setInt(3, 500000);
                pstmt1.setString(4, "코웨이");
                int result1 = pstmt1.executeUpdate();

                // ---------- 2번 작업 시작 ---------- //
                try (PreparedStatement pstmt2 = conn.prepareStatement(sql2.toString())) {
                    pstmt2.setInt(1, 100);
                    pstmt2.setString(2, "10001");
                    int result2 = pstmt2.executeUpdate();

                    //쿼리가 정상적으로 실행된 경우 db에 반영
                    if (result1 == 1 && result2 == 1) {
                        conn.commit();
                        System.out.println("db에 반영됨 . . . . . . ");
                    } else {
                        conn.rollback();
                        System.out.println("db에 반영이 취소됨 ..........");
                    }
                } catch (SQLException e) {
                    conn.rollback();
                    System.out.println("2번 작업 중 오류 발생: " + e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println("1번 작업 중 오류 발생: " + e.getMessage());
            }

        } catch (SQLException se) {
            System.out.println("DB 연결 또는 SQL 오류 발생: " + se.getMessage());
        }
    }


}

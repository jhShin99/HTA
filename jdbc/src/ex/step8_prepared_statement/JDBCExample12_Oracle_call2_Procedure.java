package ex.step8_prepared_statement;

import java.sql.*;

public class JDBCExample12_Oracle_call2_Procedure {
    /**
     * CREATE OR REPLACE PROCEDURE GET_EMP(
     *              vempno IN emp.empno%type,
     *              vename OUT emp.ename%type,
     *              vsal OUT emp.sal%type
     *              )
     * IS
     * BEGIN
     *     SELECT ename, sal
     *     INTO   vename, vsal
     *     FROM   emp
     *     WHERE  empno=vempno;
     * END;
     */

    /**
     * CMD창에
     * @GET_EMP
     * VAR VAR_ENAME VARCHAR2(15)
     * VAR VAR_SAL NUMBER
     * EXEC GET_EMP(7788, :VAR_ENAME, :VAL_SAL)
     *
     * PRINT VAR_ENAME VAR_SAL
     * 입력하기
     */
    public static void main(String[] args) {
        Connection conn = null;

        /**
         * 저장 프로시저 및 함수 호출
         * 데이터베이스에 미리 작성된 프로시저나 함수를 호출할때 CallableStatement를 사용합니다.
         */

        CallableStatement cstmt = null;

        try {
            //JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //데이터베이스 연결
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

            //CallableStatement 생성
            cstmt = conn.prepareCall("{call GET_EMP(?,?,?)}");

            //입력 파라미터 설정
            cstmt.setInt(1, 7788);

            //출력 파라미터 설정
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.registerOutParameter(3, Types.NUMERIC);

            //프로시저 실행
            cstmt.execute();

            //출력 파라미터 값 얻기
            String ename = cstmt.getString(2);
            int sal = cstmt.getInt(3);

            System.out.println("ename : " + ename);
            System.out.println("sal   : " + sal);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

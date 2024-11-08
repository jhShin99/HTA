package ex.step8_prepared_statement;

import java.sql.*;

public class JDBCExample11_Oracle_call1_Function {

    public static void main(String[] args) {
        Connection conn = null;

        /**
         * CREATE OR REPLACE FUNCTION CAL_BONUS(VEMPNO IN EMP.EMPNO%TYPE)
         * RETURN NUMBER --함수 CAL_BONUS에 의해서 되돌려지는 값은 수치데이터
         * IS
         *   VSAL NUMBER(7,2);
         * BEGIN
         *     SELECT SAL
         *     INTO   VSAL
         *     FROM   EMP
         *     WHERE  EMPNO = VEMPNO; -- VEPNO로 사원번호를 조회하여
         *                            -- 급에 컬럼값을 VSAL에 저장
         *
         *     RETURN (VSAL * 2); -- 함수의 결과값을 되돌린다.
         * END;
         *
         */

        /**
         * 1. 저장 프로시저 및 함수 호출
         *    데이터베이스에 미리 작성된 프로시저나 함수를 호출할 때 CallableStatement를 사용합니다.
         * 2. IN/OUT 파라미터 처리
         *    프로시저나 함수는 입력(IN) 파라미터와 출력(OUT) 파라미터를 받을 수 있습니다.
         *    CallableStatement는 이러한 파라미터를 설정하거나 결과로 받을 수 있습니다.
         * 3. 쿼리 실행 및결과 처리
         *    일반 쿼리처럼 실행하여 결과를 얻을 수 있습니다.
         */
        CallableStatement cstmt = null;
        try {
            // JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //데이터베이스 연결
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

            //CallableStatement 생성
            cstmt = conn.prepareCall("{? = call CAL_BONUS(?)}"); //함수 호출 문 (첫 번째 ?는 반환값)

            // 첫 번째 ?에 해당하는 반환값의 타입 설정
            cstmt.registerOutParameter(1, Types.NUMERIC);

            //입력 파라미터 설정
            cstmt.setInt(2, 7788); //두 번째 ?에 해당하는 입력 파라미터 설정(사원 번호)

            //함수 실행
            cstmt.execute();

            //반환값 얻기 (첫 번째 ?에서 값을 가져옴)
            double salary = cstmt.getDouble(1); // 첫 번째 ?에서 반환된 급여 값을 가져옴
            System.out.println("7788 사원의 급여 : " + salary);
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cstmt != null) {

            }
        }
    }
}

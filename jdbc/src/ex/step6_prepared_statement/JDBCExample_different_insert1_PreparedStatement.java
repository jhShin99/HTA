/**
 * PreparedStatement
 *
 *      1. PreparedStatement의 부모는 Statement입니다.
 *
 *      2. SQL 문장은 실행을 위해서는 컴파일이 필요한데 PreparedStatement는 사전에 컴파일을 합니다.
 *         예)pstmt = conn.preparedStatement(sql);
 *
 *      3. PreparedStatement는 SQL문장이 미리 컴파일이 되기 때문에 조건문이 바뀌지 않고
 *         조건값만 바뀌는 경우, 삽입할 데이터만 바뀌는 경우 등에 사용하면 좋습니다.
 *         즉, 한 번 미리 컴파일을 해두면 같은 쿼리에 대해서 컴파일은 하지 않고 값만 설정해서 수행합니다.
 *         Statement는 같은 쿼리라고 해도 매번 컴파일 과정을 거칩니다.
 *         따라서 같은 쿼리를 실행하더라도 PreparedStatement가 Statement보다 실행속도가 빠릅니다.
 *
 *         예) insert into test(no, ename) values (1, '홍길동');
 *         예) insert into test(no, ename) values(2, '홍길동');
 *         예) insert into test(no, ename) values(3, '홍길동');
 *
 *      4. 3번을 적용하기 위해서는 쿼리는 다음과 같이 변경합니다.
 *         바뀌는 값에 대해서 ?로 표시합니다.
 *         ?는 placeholder라고 하는데 SQL 쿼리나 프로그래밍 언어에서 값이 들어갈 자리를 임시로 표시하는 기호입니다.
 *         ?를 이용해서 쿼리를 실행할 때 동적으로 값을 전달하는 매개변수 역할을 합니다.
 *
 *         예) insert into test(no, ename) values(?, ?);
 *
 *      5. ?에 대한 값을 설정하기 위해 set자료형()메서드를 사용합니다.
 *         예) 첫번째 ?의 조건값이 정수형 1인 경우 setInt(1,1)
 *         예) 두번째 ?의 조건값이 문자형 '홍길동'인 경우 setString(2, "홍길동")
 *         Statement는 SQL문장에서 single quotation(')이 필요한 경우 직접 작성해 주었지만
 *         PreparedStatement는 자료형에 따라 알아서 single quotation(')를 처리해 줍니다.
 *
 *      6. 내부적으로 바인드 변수를 이용
 *         오라클에서 바인드 변수는 쿼리 실행 시 동적으로 값을 전달하기 위해 사용됩니다.
 *         (1) SQL 인젝션 방지
 *             SQL 인젝션 공격(SQL Injection Attack)은
 *             공격자가 웹 애플리케이션의 입력 필드나
 *             URL 쿼리 스트링을 통해 악의적인 SQL 코드를 삽입하여 데이터베이스를 조작하거나 중요한 정보를 탈취하는 공격 기법
 *
 *             *바인드 변수를 사용하면 쿼리와 데이터가 분리되어,
 *              사용자의 입력 값이 직접 SQL 쿼리 문장에 삽입되지 않아 SQL 인젝션 공격을 예방할 수 있습니다.
 *
 *             // 취약한 예제: SQL 인젝션에 취약
 *             String userId = request.getParameter("userId"); // 사용자 입력
 *
 *             String query = "SELECT * FROM users WHERE id = '" + userId + "'";
 *
 *             Statement stmt = conn.createStatement();
 *             ResultSet rs = stmt.executeQuery(query);
 *
 *             userId로 ' OR 1=1 를 입력하면 모든 로우를 반환합니다.
 *             SELECT * FROM users WHERE id = '' OR 1=1;
 *
 *         (2) 성능 향상
 *             바인드 변수를 사용하면 동일한 쿼리 구조를 재사용할 수 있으면,
 *             데이터베이스는 쿼리 실행 계획을 재사용할 수 있습니다.
 */
package ex.step6_prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCExample_different_insert1_PreparedStatement {
    public static void main(String[] args) {
        Connection conn = null;
        /**
         * create table test(no number(10), name varchar2(20) )
         */
        PreparedStatement pstmt = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "scott", "tiger");

            int result = 0, count = 0;
            long start = System.currentTimeMillis();

            String sql = "insert into test(no, name) values(?,?)";
            pstmt = conn.prepareStatement(sql);

            for (int i = 0; i < 10000; i++) {
                pstmt.setInt(1,i);
                pstmt.setString(2, "홍길동");;
                result = pstmt.executeUpdate();
                count += result;
            }
            long end = System.currentTimeMillis();

            System.out.println("소요시간:" + (end - start) + "ms" ); // 1887ms
            if (count == 10000)
                System.out.println("삽입 완료");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

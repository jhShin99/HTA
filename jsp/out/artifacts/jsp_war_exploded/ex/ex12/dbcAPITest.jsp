<%--
  1. DBCP(Database Connection Pool)
          * DBCP는 애플리케이션이 데이터베이스에 접근할 때마다 새로운 Connection을 생성하는 대신,
            미리 여러 개의 Connection을 풀(pool) 안에 만들어 두고 필요할 때마다 재사용하는 방식으로
            Connection을 사용 후 다시 풀에 반환합니다.

  2. Java Naming and Directory Interface(JNDI)
          * Java 애플리케이션이 네트워크에서 이름(name)을 이용하여 객체를 찾고 가져올 수 있도록 하는 표준 API입니다.

          * JNDI를 사용하면 Java 프로그램이나 JSP 페이지에서 응용 프로그램 내부 또는 외부에서 지정된 자원을 참조 할 수 있습니다.

  3. 톰캣의 DataSource를 이용한 DBCP 사용 과정
     (1) META-INF/context.xml 작성
         * 톰캣의 DataSource를 이용한 DBCP 사용하기 위해서 DataSource에 데이터 베이스 설정 관련 정보를 설정해야 합니다.
         * 데이터 베이스 설정 관련 정보는 META-INF/context.xml에서 작성합니다.

     (2) Context init = new InitialContext();
         DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");

         * META-INF/context.xml에서 name="jdbc/OracleDB" 설정하면
           lookup() 메서드의 인자값으로 "java:comp/env/jdbc/OracleDB"을 넘기면 됩니다.

         * java:comp/env/jdbc는 JNDI의 기본이름 중 JDBC DataSource를 참조하기 위해 사용되는 JNDI 네임스페이스의 일부
           이 경로는 JNDI를 통해 애플리케이션에서 데이터베이스 연결 정보를 얻는 방법을 정의합니다.

     (3) DataSource 객체의 getConnection() 메서드를 통해서 Connection Pool에서 Connection을 획득합니다.

     (4) Connection 객체를 통한 DBMS 작업을 수행합니다.

     (5) 모든 작업이 끝나면 DataSource 객체를 통해서 Connection Pool에 Connection을 반납합니다.

         * DBCP 라이브러리 : tomcat-dbcp.jar 파일
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 일반 데이터 베이스 작업을 위해 import 합니다. --%>
<%@ page import="java.sql.*" %>

<%-- javax.sql.DataSource 객체를 사용하기 위해 import 합니다. --%>
<%@ page import="javax.sql.*" %>

<%-- JNDI 작업을 하기 위해 import 합니다. --%>
<%@ page import="javax.naming.*" %>

<%
  try {
    Context init = new InitialContext();
    DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");


    try (
            Connection conn = ds.getConnection();
    ) {
      out.println("<h3>컨넥션 풀에 연결되었습니다.</h3>");
    }

  } catch (Exception e) {
    out.println("<h3>컨넥션 풀 연결에 실패하였습니다.</h3>");
    e.printStackTrace();
  }
%>
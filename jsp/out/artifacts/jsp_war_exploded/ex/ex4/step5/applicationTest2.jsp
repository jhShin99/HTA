<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Application Test - 초기화 파라미터 읽어오기</title>
</head>
<%--
  -초기화 파라미터는 web.xml에 작성합니다.
  getInitParameter(Name) : 이름이 Name인 웹 애플리케이션 초기화 파라미터의 값을 읽어옵니다.
                           존재하지 않을 경우 null을 리턴합니다.
--%>
<body>
  <h2>초기화 파라미터 목록</h2>
  <ul>
    <li>
      logEnabled = <%=application.getInitParameter("logEnabled")%>
    </li>
    <li>
      logLevel = <%= application.getInitParameter("logLevel")%>
    </li>
  </ul>
</body>
</html>

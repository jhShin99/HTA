<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Application Test - 초기화 파라미터 읽어오기</title>
</head>
<body>
  <h2>web.xml에서 설정한 색상으로 스타일 지정</h2>
<%
  String color = application.getInitParameter("color");
%>
  <div style="background: <%=color%>">나는 무슨 색인가요?</div>
</body>
</html>

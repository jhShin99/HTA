<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>go.jsp</title>
</head>
<body>
  <h3>go.jsp입니다.</h3>
  <p><%=pageContext.getAttribute("name")%></p>
  <p><%=request.getAttribute("name")%></p>
  <p><%=session.getAttribute("name")%></p>
  <p><%=application.getAttribute("name")%></p>
</body>
</html>

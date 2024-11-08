<!-- loginSuccess.ex -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logout</title>
</head>
<body>
<%=session.getAttribute("id")%>님 로그인 성공하셨습니다.
<a href="logout.jsp">로그아웃</a>
</body>
</html>

<!-- logout.ex -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=session.getAttribute("id")%>님 로그아웃 되셨습니다.
<%session.invalidate();%>
<a href="login.jsp">로그인</a>
</body>
</html>

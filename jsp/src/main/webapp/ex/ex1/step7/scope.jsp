<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope.ex</title>
</head>
<body>
<!-- 다른 브라우저에서 같이 켜보기 값이 다름 -->
request 속성 food 값 : <%=request.getAttribute("food")%><br>
session 속성 food 값 : <%=session.getAttribute("food")%><br>
ServletContext 속성 food 값 : <%=application.getAttribute("food")%>
</body>
</html>

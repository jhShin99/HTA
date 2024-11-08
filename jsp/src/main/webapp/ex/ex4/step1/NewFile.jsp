<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>내장 객체의 영역</title>
</head>
<body>
<%
  pageContext.setAttribute("name", "pageContext");
  request.setAttribute("name", "request");
  session.setAttribute("name", "session");
  application.setAttribute("name", "application");
%>

<p><%=pageContext.getAttribute("name")%>
</p>
<p><%=request.getAttribute("name")%>
</p>
<p><%=session.getAttribute("name")%>
</p>
<p><%=application.getAttribute("name")%>
</p>

<a href="go.jsp">다른 페이지로 이동합니다.</a>
</body>
</html>

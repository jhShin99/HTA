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

<p><%=pageContext.getAttribute("name")%></p> <!-- 페이지가 바뀌기 때문에 살아있지 않음 -->
<p><%=request.getAttribute("name")%></p>
<p><%=session.getAttribute("name")%></p>
<p><%=application.getAttribute("name")%></p>

<%--
  <jsp:forward>는 JSP에서 요청을 다른 페이지로 전달(포워딩)하는 데 사용되는 표준 액션 태그입니다
--%>
<jsp:forward page="go.jsp"/>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%--
    액션태그란 JSP 페이지 내에서 어떤 동작을 하도록 지시하는 태그 입니다.
    forward 액션은 현재 페이지를 다른 페이지로 전환할 때 사용합니다.
  --%>
  <title>액션 태그 - forward</title>
</head>
<body>
  <%
    request.setAttribute("food", "과자");
  %>
  <jsp:forward page="forwardTest2.jsp"/>
</body>
</html>

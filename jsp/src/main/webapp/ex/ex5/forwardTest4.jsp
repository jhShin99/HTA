<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>after</title>
</head>
<body>
  <div>forward 후입니다.</div>
  <p>request.getAttribute("food") => <%=request.getAttribute("food")%></p>
  <hr>
  <div>parameter로 넘어온 값</div>
  <p>request.getParameter("id") => <%=request.getParameter("id")%></p>
</body>
</html>

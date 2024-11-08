<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>redirect.ex</title>
  <style>
    body {
      background: #c7c7ef;
    }

    div {
      color: white;
      font-size: 30px;
      font-weight: bold;
    }
  </style>
</head>
<body>
request 속성 food 값 : <%=request.getAttribute("food")%><br>
session 속성 food 값 : <%=session.getAttribute("food")%>
</body>
</html>

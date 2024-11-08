<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/ch03-5.css">
</head>
<body>
<form action="/departments/search">
  <b>검색할 부서 번호를 입력하세요</b><br>
  <input type="text" name="deptno" required pattern="[0-9]{2}">
  <input type="submit" value="전송">
</form>
</body>
</html>

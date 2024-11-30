<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>joinForm.jsp</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<form action="joinPro.net" method="post">
  <h1>회원가입</h1>
  <hr>
  <b>아이디</b>
  <input type="text" name="id" maxlength="10" placeholder="Enter id" required>
  <b>Password</b>
  <input type="password" name="password" maxlength="10" placeholder="Enter password" required>
  <div class="clearfix">
    <button type="submit" class="join">회원가입</button>
    <button type="reset" class="cancel">취소</button>
  </div>
  <a href="${pageContext.request.contextPath}/loginForm.net" style="color: blue">로그인 화면</a>
</form>
</body>
</html>

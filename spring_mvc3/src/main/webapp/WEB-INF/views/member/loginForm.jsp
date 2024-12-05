<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link rel="stylesheet" href="/css/login.css">
  <script src="js/jquery-3.7.1.min.js"></script>
  <title>로그인 페이지</title>
</head>
<body>
<form name="loginProcess" action="/member/loginProcess" method="post">
  <h1>로그인</h1>
  <hr>
  <b>아이디</b>
  <input type="text" name="id" placeholder="Enter id" id="id" required
  <c:if test="${!empty saveid}">
         value="${saveid}"
  </c:if>
  >
  <b>Password</b>
  <input type="password" name="password" placeholder="Enter password" required>
  <label>
    <input type="checkbox" name="remember" style="margin-bottom: 15px"
    <c:if test="${!empty saveid}">
            checked
    </c:if>
    > Remember me
  </label>
  <div class="clearfix">
    <button type="submit" class="submitbtn">로그인</button>
    <button type="button" class="join">회원가입</button>
  </div>
</form>
</body>
</html>

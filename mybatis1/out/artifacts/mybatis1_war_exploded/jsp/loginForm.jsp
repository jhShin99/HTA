<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%--  <link rel="icon" href="${pageContext.request.contextPath}/image/orange.svg">--%>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
  <script src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
  <title>로그인 페이지</title>
  <script>
      $(function () {
          $(".join").click(function () {
              location.href = "${pageContext.request.contextPath}/joinForm.net";
          });

          const id = '${cookieId}';
          if (id) {
              $("#id").val(id);
              $("#remember").prop('checked', true);
          }
      })
  </script>
</head>
<body>
<form action="loginPro.net" method="post">
  <h1>로그인</h1>
  <hr>
  <b>아이디</b>
  <input type="text" name="id" placeholder="Enter id" required>
  <b>Password</b>
  <input type="password" name="password" placeholder="Enter password" maxlength="10" required>
  <div class="clearfix">
    <button type="submit" class="submitbtn">로그인</button>
    <button type="button" class="join">회원가입</button>
  </div>
</form>
</body>
</html>

<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <h1>세션 설정 및 메서드 사용법</h1>
  <table class="table table-striped">
    <tr>
      <td>쿠키정보</td>
      <%
        Cookie[] cookie = request.getCookies();
        if (cookie == null) { //처음 요청할 때
      %>
      <td>쿠키가 존재하지 않습니다</td>
      <%
      } else { //두 번째부터 같은 요청일 때
        for (int i = 0; i < cookie.length; i++) {
      %>
      <td>
        쿠키이름:<%=cookie[i].getName()%><br>
        (쿠키값:<%=cookie[i].getValue()%>)&nbsp;&nbsp;</td>
      <%
          } // for end
        } // else end
      %>
    </tr>
    <tr>
      <td>세션 ID</td>
      <td><%=session.getId()%></td>
    </tr>
    <tr>
      <td>세션 유효 시간 10초 설정합니다. 10초 뒤에 새로고침 합니다.</td>
      <td><%session.setMaxInactiveInterval(10);%></td>
    </tr>
    <tr>
      <td>isNew() : 새로 생성된 세션이면 true</td>
      <td><%=session.isNew()%></td>
    </tr>
    <tr>
      <td>세션 설정값 가져오기</td>
      <td><%=session.getAttribute("id")%></td>
    </tr>
  </table>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  pageContext.setAttribute("id", "pageContext");
  request.setAttribute("id", "request");
  session.setAttribute("id", "session");
  application.setAttribute("id", "application");
%>
<html>
<head>
  <title>EL 내장객체 사용예제</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <style>
      .container {
          width: 500px;
      }

      table {
          margin: auto;
      }

      td:nth-child(1), h3 {
          text-align: center;
      }
  </style>
</head>
<body>
<div class="container">
  <form action="el_result2.jsp" method="post">
    <h3>EL 예제</h3>
    <table class="table">
      <tr>
        <td>이름</td>
        <td><input type="text" name="name" value="홍길동" class="form-control"></td>
      </tr>
      <tr>
        <td>취미</td>
        <td>
          <input type="checkbox" name="hobby" id="hobby1" value="독서">독서
          <input type="checkbox" name="hobby" id="hobby2" value="놀기">놀기
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="입력" class="btn btn-info btn-block">
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>

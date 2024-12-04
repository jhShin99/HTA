<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <link rel="stylesheet" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
  <style>
      .container {
          width: 80%;
          margin-top: 10%;
      }

      span {
          color: orange;
      }
  </style>
</head>
<body>
<div class="container">
  <h3>list.jsp 입니다.</h3>
  <table class="table">
    <tr>
      <th>요청주소</th>
      <th><span>${url}</span> 처리하는 list.jsp입니다.</th>
    </tr>
    <tr>
      <th>나이</th>
      <td>${age}</td>
    </tr>
  </table>
</div>
</body>
</html>
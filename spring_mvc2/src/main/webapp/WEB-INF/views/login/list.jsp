<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <style>
      .container {
          width: 30%;
      }

      h3 {
          text-align: center;
          color: gray;
          margin-top: 10%;
      }
  </style>
</head>
<body>
<div class="container w-25">
  <h3 style="color: gray">list.jsp 입니다.</h3>
  <hr>
  <table>
    <tr>
      <td>ID</td>
      <td>${bkey.id}</td>
    </tr>
    <tr>
      <td>비밀번호</td>
      <td>${bkey.pass}</td>
    </tr>
  </table>
</div>
</body>
</html>
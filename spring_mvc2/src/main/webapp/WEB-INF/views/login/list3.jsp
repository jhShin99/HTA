<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>나이 출력</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
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
    <div class="container">
      <h3>list.jsp 입니다.</h3>
      <hr>
      <table>
        <tr>
          <td>ID</td>
          <td>${hoho.id}</td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td>${hoho.pass}</td>
        </tr>
      </table>
    </div>
  </body>
</html>
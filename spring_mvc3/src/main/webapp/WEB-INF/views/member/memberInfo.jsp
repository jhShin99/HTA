
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>관리자모드(회원 정보 보기)</title>
  <jsp:include page="../board/header.jsp"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <style>
      tr > td:nth-child(odd) {font-weight: bold}
      td {text-align: center}
      .container {width: 50%}
  </style>
</head>
<body>
<div class="container">
  <table class="table table-bordered">
    <tr>
      <td>아이디</td>
      <td>${memberinfo.id}</td>
    </tr>
    <tr>
      <td>이름</td>
      <td>${memberinfo.name}</td>
    </tr>
    <tr>
      <td>나이</td>
      <td>${memberinfo.age}</td>
    </tr>
    <tr>
      <td>성별</td>
      <td>${memberinfo.gender}</td>
    </tr>
    <tr>
      <td>이메일 주소</td>
      <td>${memberinfo.email}</td>
    </tr>
    <tr>
      <td colspan="2"><a href="list">리스트로 돌아가기</a></td>
    </tr>
  </table>
</div>
</body>
</html>

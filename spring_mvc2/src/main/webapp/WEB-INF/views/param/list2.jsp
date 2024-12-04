<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <table class="table">
    <tr>
      <th>요청주소</th>
      <th><span>${url}</span> 처리하는 list2.jsp입니다.</th>
    </tr>
      <c:forEach var="age" items="${ages}">
        <tr>
          <th>나이</th>
          <td>${age}</td>
        </tr>
      </c:forEach>
  </table>
</div>
</body>
</html>
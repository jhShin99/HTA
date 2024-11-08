<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ex.ex12.dept.Dept" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Document</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <style>
    .container {
        width: 500px;
        margin-top: 3em;
    }

    table, h4 {
        text-align: center;
    }
  </style>
</head>
<body>
  <div class="container">
    <table class="table">
      <thead>
      <tr>
        <th>DEPTNO</th>
        <th>DNAME</th>
        <th>LOC</th>
      </tr>
      </thead>
      <tbody>
<%--  <c:forEach var="dept" items="${requestScope.list}">--%>
      <c:forEach var="dept" items="${list}">
        <tr>
          <td>${dept.deptno}</td>
          <td>${dept.dname}</td>
          <td>${dept.loc}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    <c:if test="${empty list}">
      <h4>조회된 데이터가 없습니다.</h4>
    </c:if>
  </div>
</body>
</html>

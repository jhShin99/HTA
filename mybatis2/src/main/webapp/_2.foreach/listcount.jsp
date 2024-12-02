<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/css/bootstrap.min.css">
  <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
  <style>
      .red {
          color: red;
      }
  </style>
</head>
<body>
<div class="container">
  <c:if test="${!empty list}">
    <table class="table table-striped">
      <tr>
        <td class="vm">조건문</td>
        <td class="vm">부서번호[인원수]</td>
        <c:forEach items="${listcount}" var="item">
          <td>
            <button class="btn btn-info">${item.DEPTNO} [${item.CNT}명]</button>
          </td>
        </c:forEach>
      </tr>
      <tr>
        <td>번호</td>
        <td>이름</td>
        <td>사원번호</td>
        <td>직책</td>
        <td>입사일</td>
        <td>부서번호</td>
      </tr>
      <c:forEach items="${list}" var="emp" varStatus="status">
        <tr>
          <td>${status.count}</td>
          <td>${emp.ename}</td>
          <td>${emp.empno}</td>
          <td>${emp.job}</td>
          <td>${emp.hiredate}</td>
          <td>${emp.deptno}</td>
        </tr>
      </c:forEach>
    </table>
  </c:if>
  <c:if test="${empty list}">
    <h5 class="mt-3">조건을 만족하는 데이터가 없습니다.</h5>
  </c:if>
</div>
</body>
</html>

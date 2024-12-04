<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>결과폼입니다.</title>
  <script src="js/jquery-3.7.1.min.js"></script>
  <script>
      $(function () {
         <c:forEach items = "${hobby}" var="h">
            $("input[value=${h}]").prop("checked", true);
          </c:forEach>
      })
  </script>
</head>
<body>
<h1>list1.jsp - 결과 화면입니다.</h1>
<input type="checkbox" name="hobby" value="1">운동 <br>
<input type="checkbox" name="hobby" value="2">피아노 <br>
<input type="checkbox" name="hobby" value="3">게임 <br>
<input type="checkbox" name="hobby" value="4">수면 <br>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>JSTL core 라이브러리 사용 예제 2</title>
</head>
<body>
  <c:set var="test" value="<script>alert('환영합니다-escapeXml=false')</script>" />
  <c:out value="${test}" escapeXml="true"/>
</body>
</html>

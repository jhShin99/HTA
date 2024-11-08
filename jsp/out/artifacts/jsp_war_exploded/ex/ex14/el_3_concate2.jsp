<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>EL 연산자 사용 예제</title>
</head>
<body>
  <%--
    4 >= 3인 경우 <a class="page-link gray">%nbsp;다음</a>
    4 >= 3 아닌 경우 <a class="page-link ">&nbsp;다음</a>
  --%>
  <a class="page-link ${4 >= 3 ? 'gray' : ''}">&nbsp;다음</a>
  <a class="${4>=3 ? 'page-link gray' : 'page-link'}">&nbsp;다음</a>
</body>
</html>

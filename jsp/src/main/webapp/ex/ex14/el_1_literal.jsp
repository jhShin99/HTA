<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  EL 블럭(${}}에서 사용할 수 있는 값은 문자열, 정수, 부동소수점, boolean, null 가능합니다.
 --%>
<html>
<head>
  <title>리터럴 표현식</title>
</head>
<body>
<%-- "\"를 출력하려면 두 개 사용합니다. --%>
문자열 : ${'\\test'}<br>
정수 : ${20}<br>
부동소숫점 : ${3.14}<br>
boolean : ${true}<br>
null : ${null}<br> <%-- ${null}는 아무값도 출력되지 않습니다. --%>

문자열 : ${"test"}<br>
문자열 : ${'test'}<br>
</body>
</html>

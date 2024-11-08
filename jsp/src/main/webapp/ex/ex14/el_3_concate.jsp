<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>EL 연산자 사용 예제</title>
</head>
<body>
  <%-- \로 시작하면 그대로 출력됩니다, 즉, EL 문법이 아닌 일반 텍스트로 취급합니다. --%>
  <h3>\${} 안의 +는 숫자의 더하기에서 사용</h3>
  <h3>\${5+7} = ${5+7}</h3>

<%-- 만약 문자열을 연결하려면 아래와 같이 ${문자열}${문자열} 또는 += 사용합니다.  --%>
  문자열 연결 : ${'test'}${'test2'}<br>
  문자열 연결 : ${'test' += 'test2'}<br>

<%-- java.lang.NumberFormatExceptio: Form input string: "test" 오류 발생 --%>
<%-- 문자열 연결 : $(2 + 'test}<br> --%>

<%-- java.lang.NumberFormatExceptio: Form input string: "Hello" 오류 발생 --%>
<%-- 문자열 연결 : $('Hello' + 'test'}<br> --%>


</body>
</html>

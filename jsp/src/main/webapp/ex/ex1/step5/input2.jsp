<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dispatcher방식으로 이동</title>
    <link rel="stylesheet" href="/css/ch03-5.css">
</head>
<body>
<form action="/ex/ex1/step5/DispatcherServlet2" method="get">
    <b>좋아하는 음식은 무엇인가요?</b><br>
    <input type="text" name="food">
    <input type="submit" value="전송">
</form>
</body>
</html>

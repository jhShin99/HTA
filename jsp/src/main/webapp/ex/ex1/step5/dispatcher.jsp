<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dispatcher.ex</title>
    <style>
        body {
            background: pink;
        }

        div {
            color: red;
        }

        p {
            color: green;
        }
    </style>
</head>
<body>
<!-- request 객체의 getParameter() 메서드를 이용해서 파라미터 "food"의 값을 가져옵니다. -->
<%-- jsp에서 <%=값 또는 수식 또는 변수 %>는 '값 또는 수식 또는 변수'를 출력하라는 의미입니다.--%>
<div>
    request 파라미터 값 : <%=request.getParameter("food")%>
</div>
<p>
    보여주는 페이지 주소 입니다. : <%=request.getRequestURL()%>
</p>
</body>
</html>

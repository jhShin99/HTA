<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>include 테스트</title>
    <style>
        body {
            margin: 0px;
        }

        span {
            background: yellow;
        }

        footer {
            position: fixed;
            bottom: 0px;
            width: 100%;
        }

        body>footer>h3 {
            background: lightgray;
            text-align: center;
            margin: 0px;
            height: 3rem;
            line-height: 3rem;
        }

        header div {
            padding: 1%;
            text-align: right;
            background-color: green;
            color: white;
        }

        a {
            text-decoration: none;
            color: white;
        }

        a:hover {
            font-weight: bold;
        }
    </style>
    <%-- web.xml에 id, passwd 있음 --%>
    <%

        String id = application.getInitParameter("id");
        String password = application.getInitParameter("password");

        String inputId = request.getParameter("id");
        String inputPassword = request.getParameter("passwd");

        String message = id + "님 환영합니다.";
        String next = "history.back()";

        if (id.equals(inputId) && password.equals(inputPassword)) {
            session.setAttribute("id", id);
            next = "location.href = 'templateTest.jsp'";

            String checkValue = request.getParameter("remember");
            Cookie cookie = new Cookie("id", request.getParameter("id"));

            //checkValue != null 문장이 없다면 체크박스를 체크하지 않은 경우 checkValue.equals("store") 문장에서
            //if (checkValue.equals("store")) {
            //"아이디 기억하기"를 체크한 경우
            if (checkValue != null && checkValue.equals("store")) {
                //cookie.setMaxAge(60 * 60 * 24); //쿠키의 유효시간을 24시간으로 설정합니다.
                cookie.setMaxAge(2 * 60); //유효시간은 2분으로 설정합니다.
            } else {
                cookie.setMaxAge(0);
            }
            response.addCookie(cookie); //생성한 쿠키를 클라이언트로 전송합니다.
        } else if (!id.equals(inputId)) {
            message = "아이디를 확인하세요.";
        } else {
            message = "비밀번호를 확인하세요";
        }
    %>
    <script>
        alert('<%=message%>');
        <%=next%>
    </script>
</head>
<body>

</body>
</html>

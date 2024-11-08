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

        String message = null;
        String next = "location.href='template.jsp';";
        if (id.equals(inputId) && password.equals(inputPassword)) {
            session.setAttribute("id", id);
            message = id + "님 환영합니다.";
        } else {
            next = "history.back();";
            if (!id.equals(inputId)) {
                message = "아이디를 확인하세요.";
            } else {
                message = "비밀번호를 확인하세요.";
            }
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

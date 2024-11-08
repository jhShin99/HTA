<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/login.css">
</head>
<body>
<form action="login_ok.jsp" method="post">
    <h1>로그인</h1>
    <hr>
    <b>아이디</b>
    <input type="text" name="id" placeholder="Enter id" required>
    <b>비밀번호</b>
    <input type="password" name="passwd" placeholder="Enter password" required>
    <div class="clearfix">
        <button type="submit" class="submitbtn">Submit</button>
        <button type="reset" class="cancelbtn">Cancel</button>
    </div>
</form>
</body>
</html>

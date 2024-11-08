<!-- login.ex -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>Document</title>
    <link rel="stylesheet" href="/css/login.css">
</head>
<body>
<form action="/ex/test/step2/login_ok" method="post">
    <h1>로그인</h1>
    <hr>
    <b>아이디</b>
    <input type="text" name="id" placeholder="Enter id" required>
    <b>password</b>
    <input type="password" name="passwd" placeholder="Enter password" required>
    <div class="clearfix">
        <button type="submit" class="submitbtn">Submit</button>
        <button type="reset" class="cancelbtn">Cancel</button>
    </div>
</form>
<script>

</script>
</body>
</html>

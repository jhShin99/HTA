<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
</head>
<body>
    <div class="container w-25">
        <form action="updatePro.net">
            <h1>정보 수정</h1>
            <hr>
            <div class="form-group">
                <b>아이디</b>
                <input type="text" name="id" value="${mem.id}" maxlength="10" readonly class="form-control"><br>
                <b>Password</b>
                <input type="text" name="password" value="${mem.password}" class="form-control">
                <br>
            </div>
            <div class="clearfix">
                <button class="btn btn-info" type="submit">변경</button>
                <button class="btn btn-warning" type="button" onclick="history.go(-1)">취소</button>
            </div>
        </form>
    </div>
</body>
</html>

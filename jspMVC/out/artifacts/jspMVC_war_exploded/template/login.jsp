<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <%--<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>--%>
  <script src = "<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script> <%-- 위에거 대신에 --%>
  <title>쿠키를 이용한 화면 설정 예제</title>
  <style>
    .container {
        margin: 3em auto;
        box-shadow: 3px 3px 30px gray;
        width: 500px;
    }
  </style>
  <script>
    $(function() {
        const result = '${message}';
        if (result != '') {
            alert(result);
            <%session.removeAttribute("message");%>
        }

        const id = '${cookieId}';
        if(id) {
            $("#id").val(id).css("font-weight", "bold");
            $("#remember").prop("checked", true);
        }
    })
  </script>
</head>
<body>
<div class="container">
  <form action="loginProcess.net" method="post" class="border border-light p-5">
    <p class="h4 mb-4 text-center">login</p>
    <div class="form-group">
      <label for="id">ID</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id" required>
    </div>
    <div class="form-group">
      <label for="pass">Password</label>
      <input type="password" class="form-control" id="pass"
             placeholder="Enter password" name="passwd" required>
    </div>

    <div class="form-group custom-control custom-checkbox">
      <input type="checkbox" class="custom-control-input"
             id="remember" name="remember" value="store">
      <label class="custom-control-label" for="remember">아이디 기억하기</label>
    </div>

    <button type="submit" class="btn btn-info my-4 btn-block">Submit</button>

  </form>
</div>
</body>
</html>

<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String id = "";
  Cookie[] cookies = request.getCookies();
  if (cookies != null) {
    for (int i = 0; i < cookies.length; i++) {
      if (cookies[i].getName().equals("id")) {
        id = cookies[i].getValue();
      }
    }
  }
%>
<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <%--<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>--%>
  <script src = "<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script> <%-- 위에거 대신에 --%>
  <title>쿠키를 이용한 아이디 기억하기</title>
  <style>
    .container {
        margin: 3em auto;
        border: 1px solid lightgray;
        width: 500px;
    }
  </style>
  <script>
    $(function() {
        const idVal = '<%=id%>';
        if (idVal) { //문자열 idVal이 빈문자열이 아니면 true 리턴
            $("#id").val(idVal).css('font-weight', "bold");
            $("#remember").prop('checked', true);
        }

        $('form[action="login_ok.jsp"]').submit(function(){
            const $id = $("#id");
            if ($id.val().trim() ==='') {
                alert('아이디를 입력하세요');
                $id.focus();
                return false;
            }

            const $pass = $("#pass");
            if ($pass.val().trim() === '') {
                alert("비밀번호를 입력하세요");
                $pass.focus();
                return false;
            }
        })
    })
  </script>
</head>
<body>
<div class="container">
  <form action="login_ok.jsp" method="post" class="border-light p-5">
    <p class="h4 mb-4 text-center">login</p>
    <div class="form-group">
      <label for="id">ID</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
    </div>
    <div class="form-group">
      <label for="pass">Password</label>
      <input type="password" class="form-control" id="pass"
             placeholder="Enter password" name="passwd">
    </div>

    <div class="form-group custom-control custom-checkbox">
      <input type="checkbox" class="custom-control-input"
             id="remember" name="remember" value="store">
      <label class="custom-control-label" for="remember">아이디 기억하기</label>
    </div>

    <button type="submit" class="btn btn-info my04 btn-block">Submit</button>
  </form>
</div>
</body>
</html>

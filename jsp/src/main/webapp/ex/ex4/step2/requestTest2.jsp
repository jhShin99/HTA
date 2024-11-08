<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<div class="container mt-3">
  <h3>Request 예제입니다.</h3>
  <table class="table table-bordered">
    <tr>
      <td>이름</td>
      <td><% out.print(request.getParameter("name"));%></td>
    </tr>
    <tr>
      <td>성별</td>
      <td>
        <%
          if (request.getParameter("gender").equals("male")) {
              out.print("<span>남자</span>");
          } else {
              out.print("<span>여자</span>");
          }
        %>
      </td>
    </tr>
    <tr>
      <td>취미</td>
      <td>
        <%--
          hobby란 이름을 가진 파라미터는 여러 개의 값을 가질 수 있으므로
          getParameterValues() 메서드를 사용하여 String 배열로 값을 가져옵니다.
        --%>
        <%
          out.print(String.join(" ", request.getParameterValues("hobby")));
        %>
      </td>
    </tr>
  </table>
</div>
</body>
</html>

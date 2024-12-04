<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>결과폼입니다.</title>
  </head>
  <body>
  <script>
    const result = "${flashMessage2}";
    if (result != '') {
        alert(result);
    }
  </script>
  </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>결과폼입니다.</title>
  <script src="js/jquery-3.7.1.min.js"></script>
  <script>
      $(function () {
          const result = "${hobby}";
          $.each(result.split(','), function(index, item) {
              $("input[value=" + item + "]").prop("checked", true);
          })
      })
  </script>
</head>
<body>
<h1>list1.jsp - 결과 화면입니다.</h1>
<input type="checkbox" name="hobby" value="1">운동 <br>
<input type="checkbox" name="hobby" value="2">피아노 <br>
<input type="checkbox" name="hobby" value="3">게임 <br>
<input type="checkbox" name="hobby" value="4">수면 <br>
</body>
</html>
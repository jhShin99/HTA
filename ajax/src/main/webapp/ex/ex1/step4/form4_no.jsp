<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="/css/form.css">
  <script src="/js/jquery-3.7.1.js"></script>
  <script>
      $(function () {
          $("button").click(function (e) { //전송 버튼 클릭시
              const data = {
                  "name": $("#name").val(),
                  "age": $("#age").val(),
                  "address": $("#address").val()
              };
              $("div").load("process.jsp", data);
          })
      });
  </script>
</head>
<body>
<span>이름</span><input type="text" placeholder="이름을 입력하세요" id="name" name="name" required> <br>
<span>나이</span><input type="text" placeholder="나이를 입력하세요" id="age" name="age" required> <br>
<span>주소</span><input type="text" placeholder="주소를 입력하세요" id="address" name="address" required> <br>
<button type="button">전송</button>
<div></div>
</body>
</html>

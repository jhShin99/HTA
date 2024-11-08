<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>ajax 사용하기</title>
  <link rel="stylesheet" href="/css/form.css">
  <script src="/js/jquery-3.7.1.js"></script>
  <script>
      $(function () {
          $("form").submit(function (e) { //전송 버튼 클릭시
              e.preventDefault(); // 이거 없으면 깜빡거리면서 없어짐
              //객체 형태로 파라미터 이름과 값을 전달합니다.
              const data = {
                  "name": $("#name").val(),
                  "age": $("#age").val(),
                  "address": $("#address").val()
              };
              $("div").load("process.jsp", data);
          });
      })
  </script>
</head>
<body>
<form>
  <span>이름</span><input type="text" placeholder="이름을 입력하세요" id="name" name="name" required> <br>
  <span>나이</span><input type="text" placeholder="나이를 입력하세요" id="age" name="age" required> <br>
  <span>주소</span><input type="text" placeholder="주소를 입력하세요" id="address" name="address" required> <br>
  <input type="submit" value="전송">
</form>
<div></div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>비동기 예제</title>
  <link rel="icon" href="${pageContext.request.contextPath}/image/house-icon.svg"> <!-- 타이틀 왼쪽에 아이콘 나중에 써먹어보자 -->
</head>
<body>
<script>
  console.log("1");

  //비동기 처리 : 아래의 코드가 실행중이지만 다음 명령의 코드가 실행
  setTimeout(function() {
      console.log("2");
  }, 3000);

  console.log("3");
</script>
</body>
</html>

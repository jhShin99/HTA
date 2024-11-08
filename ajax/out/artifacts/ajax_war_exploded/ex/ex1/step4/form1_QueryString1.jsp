<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>ajax 사용하기</title>
  <link rel="stylesheet" href="/css/form.css">
  <script src="/js/jquery-3.7.1.js"></script>
  <script>
    $(function() {
        $("form").submit(function(e) { //전송 버튼 클릭시
            e.preventDefault(); //기본 이벤트 제거
            const name = "name=" + $("#name").val(); //쿼리스트링 작성시 매개변수와 "=" 사이에 공백없이 작성합니다.
            const age = "age=" + $("#age").val();
            const address = "address=" + $("#address").val();
            const data = name + "&" + age + "&" + address;

            //쿼리스트링 형식으로 파라미터의 이름과 값의 형태로 전달합니다.
            // $("div").load("process.jsp",
            //               "name=love&age=21&address=서울시");
            $("div").load("process.jsp", data);

        })
    })
  </script>
</head>
<body>
<%--
  form 태그의 action 속성 없습니다. 이 상태에서 전송을 클릭하면 현재 URL을 다시 불러옵니다.
 --%>
<form>
  <span>이름</span><input type="text" placeholder="이름을 입력하세요" id="name" name="name" required> <br>
  <span>나이</span><input type="text" placeholder="나이를 입력하세요" id="age" name="age" required> <br>
  <span>주소</span><input type="text" placeholder="주소를 입력하세요" id="address" name="address" required> <br>
  <input type="submit" value="전송">
</form>
<div></div>
</body>
</html>

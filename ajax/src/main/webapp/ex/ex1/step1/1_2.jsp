<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="icon" href="${pageContext.request.contextPath}/image/home.png">
  <link rel="stylesheet" href="/css/ex1.css">
  <script src="/js/jquery-3.7.1.js"></script>
  <script>
      $(function () {
         function error(responseTxt, status, xhr) {
             if (status == "success") {
                 alert("status == success\n" + responseTxt);
             } else if (status == "error") { //파일명을 sample2.txt로 변경해 보세요
                 alert("xhr.status : " + xhr.status //404
                     + "\n xhr.statusText : " + xhr.statusText);
             }
         }

         $("button").click(function() { //변경을 클릭하면
             $("button").text("로딩완료").css("color", "red");

             //<p>태그 영역에 "sample2.txt"의 내용을 불러옵니다.
             $("p").load("sample2.txt", error);
         })
      })
  </script>
</head>
<body>
<button>변경</button>
<p>변경전 : 줄이 안바뀌어요</p>
</body>
</html>

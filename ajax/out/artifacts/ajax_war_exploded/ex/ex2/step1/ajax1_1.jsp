<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="/js/jquery-3.7.1.js"></script>
  <script>
      /**
       * $.ajax(object)
       * ① url : 요청 전송 url,
       * ② type : 전송 방식 (get(기본) 또는 post),
       * ③ data : 전송할 자료들,
       * ④ cache : false를 설정하면 jQuery는 Ajax 요청에 대해 브라우저의 캐시를 사용하지 않도록 합니다.
       *            이렇게 하면 매번 서버로부터 최신 데이터를 가져오며, 캐시된 응답을 사용하지 않습니다.
       * ⑤ dataType : return data의 Type(ajax 성공 후 돌려받은 자료의 형을 정의 -"json","xml","html"),
       * ⑥ success : HTTP 요청이 성공한 경우 실행할 함수 정의,
       * ⑦ error : HTTP 요청이 실패한 경우 실행할 함수 정의
       * ⑧ complete : 요청의 실패, 성공과 상관 없이 완료 될 경우 실행할 함수 정의
       */

      $(function () {
          $("button").click(function () { //버튼을 클릭하면
              $.ajax({
                  url: "item.json",
                  dataType: "json",
                  success: function (rdata) {

                  },
              }); //ajax end
          }); //click end
      }); //$(function()
  </script>
</head>
<body>
  <div class="container">
    <button class="btn btn-info">JSON</button>
  </div>
</body>
</html>

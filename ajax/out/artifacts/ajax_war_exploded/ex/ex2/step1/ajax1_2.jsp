<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="/js/jquery-3.7.1.js"></script>
  <script>
      $(function () {
          $("button").click(function () { // 버튼을 클릭하면
              //기존 데이터가 있는 요소들 제거합니다.
              $("table").remove(); //table 요소 제거합니다.
              $(".container div").remove() //div 요소 제거합니다.

              $.ajax({
                  url: "item.json", //요청 전송 url
                  dataType: "json", //return data의 Type(ajax 성공 후 돌려받은 자료형을 정의)
                  cache: false,
                  success: function (rdata) { // HTTP 요청이 성공한 경우 실행할 함수 정의 (이벤트 핸들러)
                      // rdata는 서버에서 보낸 데이터입니다.
                      //채우기
                  },
                  error: function (request, status, error) {
                      $(".container").append("<div id = 'error'>code : "
                          + request.status + "<br>"
                          + "받은 데이터 : " + request.responseText + "<br>"
                          + "error status : " + status + "<br>"
                          + "error 메시지 : " + error + "</div>");
                  },

                  complete: function () { //요청의 실패, 성공과 상관 없이 완료 될 경우 호출
                      $(".container").append("<div id = 'com'>Ajax가 완료되었습니다.</div>");
                  }
              }); //ajax end
          })
      })
  </script>
</head>
<body>
<div class="container">
  <button class="btn btn-info">JSON</button>
</div>
</body>
</html>

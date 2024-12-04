<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <link rel="stylesheet" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
  <script src="js/jquery-3.7.1.min.js"></script>
  <script>
      $(function () {
          $("button").click(function () {
              const goUrl = $(this).attr('id');
                  $.ajax({
                      url: goUrl,
                      success: function (rdata) {
                          console.log(rdata);
                          console.log(goUrl == "url5");
                          if (goUrl == "url5") {
                              $("div#result").html(`id=\${rdata.id}, pass = \${rdata.pass}`)
                                  .css('color', 'green');
                          } else {
                              $("div#result").html(rdata).css('color', 'green');
                          }
                      },
                      error: function (request, status, error) {
                          $("div#result").html("code :"
                              + request.status + "<br>"
                              + "받은 데이터 : " + request.responseText + "<br>"
                              + "error status : " + status + "<br>"
                              + "error 메시지 : " + error).css('color', 'blue');
                      }
                  })
              })
          })
  </script>
</head>

<body>
<div class="container">
  <p>이곳은 url.jsp 입니다.</p>
  <p>
    <button class="btn btn-primary" id="url2">url2를 호출합니다.</button>
  </p>
  <p>
    <button class="btn btn-info" id="url3">url3를 호출합니다.</button>
  </p>
  <p>
    <button class="btn btn-info" id="url4">url4를 호출합니다.</button>
  </p>
  <p>
    <button class="btn btn-info" id="url5">url5를 호출합니다.</button>
  </p>
  <div id="result"></div>
</div>
</body>
</html>
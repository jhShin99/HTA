<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="/css/form.css">
  <script src="/js/jquery-3.7.1.js"></script>
  <script>
      /**
       * jQuery.get() = $.get()
       * - 서버에 데이터를 HTTP GET방식으로 보냅니다.
       * - $.get() 함수를 이용해서 data.csv 파일을 불러옵니다.
       * - $.get() 함수의 첫번째 매개변수에는 서버의 URL 주소를 지정합니다.
       * - $.get() 함수의 두번째 매개변수인 콜백함수를 이용해서 서버에서 보내온 csv 형식의 데이터를 매개변수(input)로 받습니다.
       */
      $(function() {
          $("button").click(function() {
              let output = '';

              $.get("data.csv", function(input) {
                  input.split('\n').forEach(line => {
                      line.split(',').forEach(item => {
                          output += item.trim() + "<br>";
                      });
                  });

                  $("pre").html(output);
              }); //get()
          }); //$("button").click()
      }); //$(function() {
  </script>
</head>
<body>
  <button>데이터 불러오기</button>
  <pre>변경전</pre>
</body>
</html>

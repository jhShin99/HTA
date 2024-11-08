<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="/js/jquery-3.7.1.js"></script>
  <script>
      $(function() {
          $("button").click(function() {
              // data.csv 파일을 불러옵니다.
              $.get("data.csv", function(input) {
                  let output = "<table class='table'>"
                      + "<thead><tr><th>이름</th><th>지역</th><th>나이</th></tr></thead><tbody>";

                  input.split('\n').forEach(line => {
                      output += "<tr>";
                      line.split(',').forEach(item => {
                          output += "<td>" + item.trim() + "</td>";
                      });
                      output += "</tr>";
                  });
                  output += "</tbody></table>";
                  $("pre").html(output);
              });
          });
      });
  </script>
</head>
<body>
<button type="button" class="btn btn-primary">데이터 불러오기</button>
<pre>변경전</pre>
</body>
</html>
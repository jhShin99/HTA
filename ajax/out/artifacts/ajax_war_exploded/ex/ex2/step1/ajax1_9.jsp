<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="/js/jquery-3.7.1.js"></script>
  <style>
      #error {
          color: green;
      }

      #com {
          color: blue;
      }
  </style>
</head>
<body>
<div class="container">

</div>
<script>
    function getData() {
        $.ajax({
            url: "${pageContext.request.contextPath}/dept_lib",
            type: "post",
            dataType: "json",
            cache: false,
            success: function (rdata) {
                console.log("성공" + rdata)
                if (rdata.length > 0) {
                    let output = '<div id="result"><table class="table">'
                        + '<thead><tr><th>부서번호</th><th>부서명</th><th>지역</th></tr></thead>'
                        + '<tbody>';
                    $(rdata).each(function (index, item) {
                        output += '<tr>';
                        output += '  <td>' + item.deptno + '</td>';
                        output += '  <td>' + item.dname + '</td>';
                        output += '  <td>' + item.loc + '</td>';
                        output += '</tr>';
                    }); //each end
                    output += '</tbody></table></div>';
                    $('.container').append(output);
                } else {
                    $('.container').append('<div>데이터가 존재하지 않습니다.</div>');
                }
            }
        }); // ajax end
    }
    getData();
</script>
</body>
</html>
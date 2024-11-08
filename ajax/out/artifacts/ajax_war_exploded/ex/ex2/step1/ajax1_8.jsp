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
  <script>
      $(function () {
              $("table").remove(); // table 요소 제거합니다.
              $(".container div").remove(); // div 요소 중 특정 클래스만 제거합니다.

              //버튼 클릭 없이 바로 불러오기
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
                  },
                  error: function (request, status, error) {
                      $(".container").append("<div id='error' class='alert alert-danger'>code : "
                          + request.status + "<br>"
                          + "받은 데이터 : " + request.responseText + "<br>"
                          + "error status : " + status + "<br>"
                          + "error 메시지 : " + error + "</div>");
                  },

                  complete: function () { //요청의 실패, 성공과 상관 없이 완료 될 경우 호출
                      $(".container").append("<div id='com' class='alert alert-info'>Ajax가 완료되었습니다.</div>");
                      console.log('ajax() - complete');
                  }
              }); // ajax end

              console.log('ajax() 뒤');
      }); // $(function() {
  </script>
</head>
<body>
<div class="container">
  <button class="btn btn-info">라이브러리를 이용한 json 형식으로 dept 내용 가져오기</button>
</div>
</body>
</html>
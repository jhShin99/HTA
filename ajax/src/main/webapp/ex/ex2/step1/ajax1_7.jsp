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
          $("button").click(function () { // 버튼을 클릭하면
              //기존 데이터가 있는 요소들 제거합니다.
              $("table").remove(); // table 요소 제거합니다.
              $(".container div").remove(); // div 요소 중 특정 클래스만 제거합니다.

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
          }); // click end
      }); // $(function() {
  </script>
</head>
<body>
<div class="container">
  <button class="btn btn-info">라이브러리를 이용한 json 형식으로 dept 내용 가져오기</button>
</div>
</body>
</html>
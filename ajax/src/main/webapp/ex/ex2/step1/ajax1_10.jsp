<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="/js/jquery-3.7.1.js"></script>
</head>
<body>
<div class="container">
  <h3 class="mt-5">검색할 부서 번호를 입력하세요</h3>
  <form class="mb-3">
    <div class="row">
      <input type="search" name="deptno" pattern="[0-9]{2}" required class="form-control col-8 ml-3">
      <button class="btn btn-info">검색</button>
    </div>
  </form>
</div>
<script>
    function getData() {
        $("#result").remove();

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
            }
        });
    }

    getData();

    $("form").submit(function(e) {
        e.preventDefault();

        $("#result").remove();

        $.ajax({
            url: "${pageContext.request.contextPath}/dept_lib_search",
            data : {"deptno" : $("input[name=deptno]").val()},
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
        });
    })
</script>
</body>
</html>
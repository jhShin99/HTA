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
    function getData(go, sendData) {
        console.log(sendData);
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/" + go,
            data : {"deptno" : sendData},
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

    getData('dept_lib');

    $("form").submit(function(event) {
        event.preventDefault();
        $("#result").remove();
        const sendData = $("input[name='deptno']").val();
        getData('dept_lib_search', sendData);
    })
</script>
</body>
</html>
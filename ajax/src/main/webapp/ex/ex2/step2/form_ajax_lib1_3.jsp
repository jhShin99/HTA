<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="/js/jquery-3.7.1.js"></script>
  <title>DB Basic</title>
  <style>
    .container {width: 50%}
  </style>
</head>
<body>
  <div class="container">
    <form id="insert-form">
      <fieldset>
        <legend>데이터 추가</legend>
        <table class="table">
          <tr>
            <th><label>상품명</label></th>
            <td><input type="text" name="name" class="form-control" id="name" required></td>
          </tr>
          <tr>
            <th><label>가격</label></th>
            <td><input type="text" name="price" class="form-control" id="price" pattern="[0-9]+" required></td><%-- 숫자 1개 이상 --%>
          </tr>
          <tr>
            <th><label>메이커</label></th>
            <td><input type="text" name="maker" class="form-control" id="maker" required></td>
          </tr>
          <tr>
            <td colspan="2">
              <button type="submit" class="btn btn-primary btn-block">추가</button>
            </td>
          </tr>
        </table>
      </fieldset>
    </form>
  </div>
  <script>
    //get방식 전송시 데이터 가져오기, post 방식 전송시 삽입과 데이터 가져오기
    function selectData(m, sendData) {
        $("#result").remove();
        $.ajax({
            type: m, //"get", "post" - 전송방식
            url: "${pageContext.request.contextPath}/product",
            data : sendData,
            dataType: "json",
            success: function (rdata) {
                console.log("성공" + rdata)
                if (rdata.length > 0) {
                    let output = '<div id="result"><table class="table">'
                        + '<thead><tr><th>아이디</th><th>상품명</th><th>가격</th><th>메이커</th></tr></thead>'
                        + '<tbody>';
                    $(rdata).each(function (index, item) {
                        output += '<tr>';
                        output += '  <td>' + item.id + '</td>';
                        output += '  <td>' + item.name + '</td>';
                        output += '  <td>' + item.price + '</td>';
                        output += '  <td>' + item.maker + '</td>';
                        output += '</tr>';
                    }); //each end
                    output += '</tbody></table></div>';
                    $('.container').append(output);
                    $('input').val('');
                } else {
                    $('.container').append('<div id="result">데이터가 존재하지 않습니다.</div>');
                }
            }
        });
    }

    //초기 화면에 데이터를 표시합니다.
    selectData("get");

    //데이터를 추가합니다.
    $("#insert-form").submit(function(event) {

        //기본 이벤트를 제거합니다.
        event.preventDefault();
        const sendData = $("#insert-form").serialize(); // 입력 양식에 적힌 값을 쿼리스트링으로 바꿉니다.
        selectData("post", sendData);

    }); // submit end
  </script>
</body>
</html>

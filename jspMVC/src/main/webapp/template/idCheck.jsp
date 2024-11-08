<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang='ko'>
<head>
  <meta charset='UTF-8'>
  <title>Document</title>
  <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<div id="message"></div>
<script>
    const message = ["사용중인 아이디 입니다.", "사용가능한 아이디 입니다."];
    const color = ["red", "green"];
    const index = ${result + 1};
    $("#message").text(message[index]).css('color', color[index]);

    //2초후 자동으로 창을 닫습니다.
    setTimeout(function () {
        //opener : 현재 창(자식창)을 열어준 창(부모창)
        $(opener.document).find("#opener_message")
            .text(message[index])
            .css('color', color[index]);
        $(opener.document).find("#result")
            .val("${result}");
        window.close();
    }, 2000);
</script>
</body>
</html>
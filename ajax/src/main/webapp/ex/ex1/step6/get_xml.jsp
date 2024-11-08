
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="/js/jquery-3.7.1.js"></script>
</head>
<body>
<script>
    /**
     * xml 형식의 데이터를 전부 data로 받습니다.
     */
    $(function() {
        $("button").click(function() { // 버튼을 클릭하면
            $.get('item.xml', function(data) { //data에는 item.xml의 내용이 들어 있습니다.
                $("table").remove(); //테이블이 존재하면 제거해 계속 추가 되지 않도록 합니다.

                let output = "<table class='table'><thead>"
                    + "<tr><th>id</th><th>name</th><th>price</th>"
                    + "<th>description</th></tr></thead><tbody>";

                // 서버에서 얻어온 데이터에서 셀렉터로 item 태그를 찾습니다.
                $(data).find('item').each(function(index, item) {

                    output += "<tr>"
                           + "<td>" + $(item).attr("id") + "</td>"
                           + "<td>" + $(item).attr("name") + "</td>"
                           + "<td>" + $(item).find("price").text() + "</td>"
                           + "<td>" + $(item).find("description").text() + "</td>"
                           + "</tr>";
                    /**
                     * $(item).attr : 속성 id의 값을 구해옵니다.
                     * $(item).find("price") : price 태그를 찾습니다.
                     * $(item).find("price").text() : price 태그 사이의 값을 구해옵니다.
                     * $(item).find("description") : description 태그를 찾습니다.
                     * $(item).find("description").text() : description 태그 사이의 값을 구해옵니다.
                     */
                }); //each end
                output += "</tbody></table>";
                $(".container").append(output);
            }); //get() end
        }); //click end
    }); //$() end
</script>
  <button class="btn btn-primary">버튼</button>
  <div class="container"></div>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--https://www.w3schools.com/bootstrap4/tryit.asp?filename=trybs_filters_table&stacked=h --%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

<div class="container mt-3">
  <h2>인기상품 목록 Table</h2>
  <p>상품입력하세요.</p>
  <input class="form-control" id="myInput" type="search" placeholder="Search..">
  <br>
  <table class="table table-bordered">
    <thead>
    <tr>
      <th>상품이름</th>
      <th>가격</th>
      <th>제조사</th>
    </tr>
    </thead>
    <tbody id="myTable">
    <tr>
      <td>iPhone 15 Pro</td>
      <td>1,700,000</td>
      <td>Apple</td>
    </tr>
    <tr>
      <td>Apple watch SE</td>
      <td>300,000</td>
      <td>Apple</td>
    </tr>
    <tr>
      <td>Airpods</td>
      <td>190,000</td>
      <td>Apple</td>
    </tr>
    <tr>
      <td>Galaxy S20</td>
      <td>1,200,000</td>
      <td>SAMSUNG</td>
    </tr>
    </tbody>
  </table>

</div>

<script>
    $(document).ready(function(){
        $("#myInput").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function() {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });

        /*$("myInput").on("keyup", function() {
            const value = $(this).val().toLowerCase();
            $("myTable tr").each(function() {
                console.log($(this).text().toLowerCase().indexOf(value) > -1);

                //toggle(true)이면 해당 엘리먼트가 보이고 false이면 숨겨요
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
            })
        })*/
    });
</script>

</body>
</html>

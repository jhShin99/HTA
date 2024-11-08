
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
  <h2>신상품 목록 Table</h2>
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
      <td>iPhone 16 Pro Max</td>
      <td>2,500,000</td>
      <td>Apple</td>
    </tr>
    <tr>
      <td>Apple watch 8</td>
      <td>900,000</td>
      <td>Apple</td>
    </tr>
    <tr>
      <td>Airpods Pro</td>
      <td>390,000</td>
      <td>Apple</td>
    </tr>
    <tr>
      <td>Galaxy Z Flips</td>
      <td>2,000,000</td>
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
    });
</script>

</body>
</html>

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
</body>
</html>

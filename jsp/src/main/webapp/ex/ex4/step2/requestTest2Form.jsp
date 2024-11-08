<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <style>
      .container {
          width: 70%;
          margin-top: 30px;
      }

      h3 {
          text-align: center;
      }
  </style>
  <script>
      $(function() {
          $('form[action="requestTest1.jsp"]').submit(function() {
              let selected = $('input[name="gender"]:checked').length;
              if (selected < 1) {
                  alert("성별을 선택해 주세요");
                  return false;
              }

              selected = $('input[name="hobby"]:checked').length;
              if (selected < 1) {
                  alert("취미를 한 개 이상 선택해 주세요");
                  return false;
              }
          })
      })
  </script>
</head>
<body>
<div class="container">
  <h3>Request 예제입니다.</h3>
  <form action="requestTest2.jsp" method="get">
    <table class="table">
      <tr>
        <td>이름</td>
        <td><input type="text" name="name" class="form-control" required></td>
      </tr>
      <tr>
        <td>성별</td>
        <td>
          <label>
            <input type="radio" name="gender" value="male">남자
          </label>
          <label>
            <input type="radio" name="gender" value="female">여자
          </label>
        </td>
      </tr>
      <tr>
        <td>취미</td>
        <td>
          <label>
            <input type="checkbox" value="독서" name="hobby"> 독서
          </label>
          <label>
            <input type="checkbox" value="게임" name="hobby"> 게임
          </label>
          <label>
            <input type="checkbox" value="TV시청" name="hobby"> TV시청
          </label>
          <label>
            <input type="checkbox" value="축구" name="hobby"> 축구
          </label>
          <label>
            <input type="checkbox" value="기타" name="hobby"> 기타
          </label>
        </td>
      </tr>
      <tr>
        <td colspan="2"><button type="submit" class="btn btn-success">전송</button></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>

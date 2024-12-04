<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <link rel="stylesheet" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
    <table class="table">
      <tr>
        <th>ID</th>
        <td>${id}</td>
      </tr>
      <tr>
        <th>비밀번호</th>
        <td>${password}</td>
      </tr>
      <tr>
        <th>주민번호</th>
        <td>${jumin1} - ${jumin2}</td>
      </tr>
      <tr>
        <th>E-Mail</th>
        <td>${email}@${domain}</td>
      </tr>
      <tr>
        <th>성별</th>
        <td>${gender == 'm' ? '남자' : '여자'}</td>
      </tr>
      <tr>
        <th>취미</th>
        <td>${hobby}</td>
      </tr>
      <tr>
        <th>우편번호</th>
        <td>${post1}</td>
      </tr>
      <tr>
        <th>주소</th>
        <td>${address}</td>
      </tr>
      <tr>
        <th>자기소개</th>
        <td>${intro}</td>
      </tr>
    </table>
  </div>
</body>
</html>
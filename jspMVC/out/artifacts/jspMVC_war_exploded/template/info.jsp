<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <style>
      .container {
          margin-top: 3em;
      }

      table, h4 {
          text-align: center;
      }

      caption {
          text-align: center;
          font-weight: bold;
          caption-side: top;
          font-size: 1.5em;
      }
  </style>
</head>
<body>
<jsp:include page="top.jsp"/>
<div class="container">
  <c:if test="${!empty temp}">
    <table class="table">
      <caption>${temp.id}의 상세 정보</caption>
      <tbody>
      <tr>
        <th>아이디</th>
        <td>${temp.id}</td>
      </tr>
      <tr>
        <th>비밀번호</th>
        <td>${temp.password}</td>
      </tr>
      <tr>
        <th>주민번호</th>
        <td>${temp.jumin}</td>
      </tr>
      <tr>
        <th>이메일</th>
        <td>${temp.email}</td>
      </tr>
      <tr>
        <th>성별</th>
        <td>${temp.gender == 'm' ? '남자' : '여자'}</td>
      </tr>
      <tr>
        <th>취미</th>
        <td>${temp.hobby}</td>
      </tr>
      <tr>
        <th>우편번호</th>
        <td>${temp.post}</td>
      </tr>
      <tr>
        <th>주소</th>
        <td><c:out value="${temp.address}"/></td> <!-- 좀 길면 c:out value 사용하라함 -->
      </tr>
      <tr>
        <th>자기소개</th>
        <td><c:out value="${temp.intro}"/></td>
        <%-- <td>${temp.intro}</td> --%>
      </tr>
      <tr>
        <th>가입일</th>
        <td>${temp.register_date}</td>
      </tr>
      </tbody>
    </table>
  </c:if>
</div>
<footer>
  <jsp:include page="bottom.jsp"/>
</footer>
</body>
</html>

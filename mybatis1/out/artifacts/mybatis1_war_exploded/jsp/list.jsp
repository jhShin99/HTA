<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/css/bootstrap.min.css">
  <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
</head>
<body>
  <div class="container w-50">
    <h1 class="text-center">회원 리스트</h1>
    <table class="table">
      <tr>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>수정</th>
        <th>삭제</th>
      </tr>
      <c:forEach var="member" items="${list}">
        <tr>
          <td>${member.id}</td>
          <td>${member.password}</td>
          <td><button class="btn btn-info btn-sm" type="button" data-id="${member.id}">수정</button></td>
          <td>
            <c:if test="${member.id != 'admin'}">
              <button class="btn btn-danger btn-sm" type="button" data-id="${member.id}">삭제</button>
            </c:if>
          </td>
        </tr>
      </c:forEach>
    </table>
    <div><a href="main.net">메인으로</a></div>
  </div>
  <script>
    $(".btn-info").click(function() {
        const id = $(this).attr("data-id");
        location.href = 'updateForm.net?id=' + id;
    })

    $(".btn-danger").click(function() {
        const id = $(this).attr("data-id");
        if (confirm("정말 삭제 하시겠습니까?")) {
            location.href = "delete.net?id=" + id;
        }
    })
  </script>
</body>
</html>

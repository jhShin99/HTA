<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>EL 연산자 사용 예제</title>
  <style>
    .gray {
        color: gray;
        font-weight: bold;
    }
  </style>
</head>
<body>
<%--
  pageContext에 page 속성값을 4
  pageContext에 maxPage 속성값을 3으로 설정합니다.

  page >= maxPage 인 경우 <a class="page-link gray"&nbsp;다음</a>
  page < maxPage 인 경우 <a class="page-link ">&nbsp;다음</a>

  gray 클래스가 적용되면 회색의 굵은 글자가 되도록 합시다.
--%>
<%
  pageContext.setAttribute("page", 4);
  pageContext.setAttribute("maxPage", 3);
%>

<a class="page link ${page > maxPage ? "gray" : ""}">&nbsp;다음</a>
<hr>
<a class="${page > maxPage ? "page link gray" : "page link "}">&nbsp;다음</a>
<%--<a class="page link ${pageScope.page > pageScope.maxPage ? "gray" : ""}">&nbsp;다음</a>--%>
</body>
</html>

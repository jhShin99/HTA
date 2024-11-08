<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <h1>쿠키, URL/URI, 요청방식에 관련된 정보 예제</h1>
  <table class="table table-striped">
    <tr>
      <td>쿠키정보</td>
      <%
        Cookie[] cookie = request.getCookies();
        if (cookie == null) { //처음 요청할 때
      %>
      <td>쿠키가 존재하지 않습니다</td>
      <%
      } else { //두 번째부터 같은 요청일 때
        for (int i = 0; i < cookie.length; i++) {
      %>
      <td><%=cookie[i].getName()%>(<%=cookie[i].getValue()%>)&nbsp;&nbsp;</td>
      <%
          } // for end
        } // else end
      %>
    </tr>
    <tr>
      <td>서버 도메인명</td>
      <td><%=request.getServerName()%></td>
    </tr>
    <tr>
      <td>서버 포트번호</td>
      <td><%=request.getServerPort()%></td>
    </tr>
    <tr>
      <td>요청 URL</td>
      <td><%=request.getRequestURL()%></td>
    </tr>
    <tr>
      <td>요청 URI(Uniform Resource Identifier)</td>
      <td><%=request.getRequestURI()%></td>
    </tr>
    <tr>
      <td>요청 쿼리</td>
      <td><%=request.getQueryString()%></td>
    </tr>
    <tr>
      <td>컨텍스트 경로
        <%-- 컨텍스트 경로(톰캣에서 Context는 웹 애플리케이션을 의미합니다.) --%>
      <td><%=request.getContextPath()%></td>
      </td>
    </tr>
    <tr>
      <td>프로토콜</td>
      <td><%=request.getProtocol()%></td>
    </tr>
  </table>
</div>
</body>
</html>

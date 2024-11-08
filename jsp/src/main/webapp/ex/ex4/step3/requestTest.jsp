<%@ page import="java.util.Enumeration" %><%--
  세션은 기본적으로 컨테이너 내부에 정보를 저장 및  관리하고 저장된 정보에 접근하기 위해서
  세션ID라는 것을 사용합니다. 세션 ID는 쿠키를 사용해서 유지되며 이 때의 쿠키 이름은 JSESSIONID 입니다.
--%>
<%--
  (1) 기존 브라우저를 종료해 주세요
  (2) 실행 하세요
  (3) 새로고침 해보세요~
      JSESSIONID가 추가로 보이는지 확인해 주세요
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Request Test</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
    <h1>헤더정보 예제</h1>
    <table class = "table table-striped">
      <tr>
        <td>헤더이름</td>
        <td>헤더값</td>
      </tr>
      <%
        //getHeaderNames() 메서드 : HTTP요청 헤더에 포함된 모든 헤더 이름을
        //Enumeration 객체로 리턴합니다.
        Enumeration<String> e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String headerName = e.nextElement();

      %>
      <tr>
        <td><%=headerName%></td>
        <td>
          <%--getHeader(): 매개변수로 지정된 이름으로 할당된 값을
                           리턴합니다. 없는 경우 null을 리턴합니다. --%>
          <%=request.getHeader(headerName)%>
        </td>

      </tr>
      <%
        }
      %>
    </table>
  </div>
</body>
</html>

<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //쿠키 객체를 생성하고 language1이라는 쿠키 이름에
  //입력받은 language설정 값을 저장합니다.
  Cookie cookie = new Cookie("language1", request.getParameter("language"));

  //시간을 설정하지 않으면(setMaxAge()메서드 사용하지 않을 때)
  //브라우저 종료시 쿠키도 삭제됩니다.
  //또는 메서드를 호출할 때 인자 값으로 0을 주면 쿠키는 삭제 됩니다.
  cookie.setMaxAge((60*60*24)); //쿠키의 유효시간을 24시간으로 설정합니다.(단위는 초)
  response.addCookie(cookie); //클라이언트로 쿠키값을 전송합니다.
%>
<script>
  location.href = "cookieExample.jsp"; /* cookieExample.jsp로 돌아갑니다. */
</script>

<%--
  1. 쿠키를 생성합니다.
     쿠키 이름은 "language1", 값은 선택한 radio 버튼의 값

  2. 쿠키의 유효시간은 24시간 설정합니다.

  3. 클라이언트로 쿠키값을 전송합니다.
--%>
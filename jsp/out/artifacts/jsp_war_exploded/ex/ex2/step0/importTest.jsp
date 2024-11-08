<%--
  JSP 지시어(Directive)
  형식) <%@ ..... %>
      JSP 파일 내에서 JSP를 실행할 컨테이너에서 해당 페이지를 어떻게
      처리할 것인가에 대한 설정 정보들을 지정해 주는데 사용됩니다.

      지시어의 종류)
              page 지시어, include 지시어, taglib 지시어

      ① page 지시어
         JSP 페이지에 대한 속성을 지정하는 지시어입니다.
         형식) <%@ page 속성=값 ..... %>

      ② include 지시어
         특정한 JSP파일 또는 HTML 파일을 해당 JSP페이지에 삽입할 수 있도록 하는 기능을 제공하는 지시어입니다.
         형식) <%@ include file="파일경로" %>

      ③ taglib 지시어는 JSTL(JSP Standard Tag Library)이나
         커스텀 태그 등 라이브러리를 JSP에서 사용할 때 접두사를 지정하기 위해 사용됩니다.
         형식) <%@ taglib uri="http://taglib.com/sampleURI" prefix="samplePrefix" %>
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 1. contentType :
        JSP페이지가 생성하는 문서의 종류와 그 문서를 웹 브라우저로 전송할 때 사용되는 인코딩 타입입니다.
        문서의 종류는 생성할 응답의 형태가 어떠한 MIME형식으로 되어 있는지 지정하는 속성입니다.

        MIME(Multipurpose Internet Mail Extensions)란 인터넷을 통해 문서를 주고 받을 때 사용되는
        문서 형식을 정의해 놓은 것입니다.
        예로 text/html(HTML 문서), text/plain(순수 텍스트 파일), image/gif(gif 형식의 이미지),
        video/avi(avi 형식의 비디오 파일) 등 여러 가지 타입을 제공합니다.

     2. pageEncoding : 현재 페이지의 문자 인코딩 방식을 지정할 때 사용하는 속성입니다.
        이 속성이 지정되어 있지 않으면 contentType 속성에서 지정된 문자 코드로 JSP파일을 읽어 들입니다.
-->
<!DOCTYPE>
<%--
  SimpleDateFormat 클래스 사용위해 import 속성을 이용합니다.
  import 속성 : JSP 페이지에서 사용할 클래스(인터페이스) 지정 합니다.
               여러개를 지정할 경우 콤마로 구분하여 표시할 수 있습니다.
  <%@page import="java.text.SimpleDateFormat, java.util.*"%>
 --%>
<%@ page import="java.text.SimpleDateFormat"%>

<%-- Date클래스 사용위해 import --%>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>import 속성 테스트</title>
</head>
<body>
<h1>현재 시간은 <%=new SimpleDateFormat().format(new Date())%>입니다.</h1>
</body>
</html>

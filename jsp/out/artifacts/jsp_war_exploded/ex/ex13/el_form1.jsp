<%--
  * 표현언어(Expression Language: EL)
  - JSP 스크립트 대신하여 속성 값들을 좀 더 편리하게 출력하기 위해 제공되는 언어입니다.
  - 톰캣에서 제공하기 때문에 따로 설정할 필요 없습니다.
  - 형식) ${ }


  1. 표현식 <%=article.getId()%> //article이 자바빈인 경우
  => 표현언어 ${article.id} 또는 ${article["id"]} 또는 ${article['id']}

  2. <%=request.getParameter("name")%>
     => ${param.name}

  3. <%=request.getParameterValues("hobby")%>
     => ${paramValues.hobby} 결과는 스트링 배열(String[])
        차례대로 출력할 경우
        - ${paramValues.hobby[0]}
        - ${paramValues.hobby[1]}
        - ${paramValues.hobby[2]}

 4. <%=request.getAttribute("hoho")%>
    => ${requestScope.hoho}

 5. <%=session.getAttribute("id")%>

  6.${hoho}
    이 경우에는 pageContext -> request -> session -> application 객체의 영역 순으로
    'hoho' 이름의 attribute를 찾습니다.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  pageContext.setAttribute("id", "pageContext");
  request.setAttribute("id", "request");
  session.setAttribute("id", "session");
  application.setAttribute("id", "application");
%>
<html>
<head>
  <title>EL 내장객체 사용 예제</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <style>
    .container {
        width: 500px;
    }
  </style>
</head>
<body>
  <div class="container mt-5">
    <h5>page영역의 속성 id의 값 : ${pageScope.id}</h5>
    <h5>request영역의 속성 id의 값 : ${requestScope.id}</h5>
    <h5>어느 영역의 속성 id의 값 : ${id}</h5>
  </div>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <style>
    table {
      border-collapse: collapse;
      width: 50%;
      margin: 0 auto;
    }

    tr {
      height: 3em;
      border-bottom: 1px solid black;
    }

    td {
      width: 60%;
    }
  </style>
</head>
<body>
<table>
    <tbody>
    <tr>
      <th>아이디</th>
      <td><%=request.getAttribute("id")%></td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td><%=request.getAttribute("pass")%></td>
    </tr>
    <tr>
      <th>주민번호</th>
      <td><%=request.getAttribute("jumin1")%> - <%=request.getAttribute("jumin2")%></td>
    </tr>
    <tr>
      <th>이메일</th>
      <td><%=request.getAttribute("emailAddr")%></td>
    </tr>
    <tr>
      <th>성별</th>
      <td><%=request.getAttribute("gender")%></td>
    </tr>
    <tr>
      <th>취미</th>
      <td><%=request.getAttribute("hobby")%></td>
    </tr>
    <tr>
      <th>우편번호</th>
      <td><%=request.getAttribute("post1")%></td>
    </tr>
    <tr>
      <th>주소</th>
      <td><%=request.getAttribute("address")%></td>
    </tr>
    <tr>
      <th>자기소개</th>
      <td><%=request.getAttribute("intro")%></td>
    </tr>
    </tbody>
  </table>
</body>
</html>

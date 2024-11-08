<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
  <table class="table table-bordered table-striped">
    <tr>
      <td>작성자</td>
      <td><%=request.getAttribute("name")%></td>
    </tr>
    <tr>
      <td>제목</td>
      <td><%=request.getAttribute("subject")%></td>
    </tr>
    <tr>
      <td>파일명1</td>
      <td>
        <a href="<%=request.getContextPath()%>/down?fileName=<%=request.getAttribute("systemName1")%>"><%=request.getAttribute("origfileName1")%></a>
      </td>
    </tr>
    <tr>
      <td>파일명2</td>
      <td>
        <a href="<%=request.getContextPath()%>/down?fileName=<%=request.getAttribute("systemName2")%>"><%=request.getAttribute("origfileName2")%></a>
      </td>
    </tr>
    <tr>
      <td>uploadPath</td>
      <td><%=request.getAttribute("uploadPath")%></td>
    </tr>
  </table>
</body>
</html>

<%@ page import="java.util.ArrayList" %>
<%@ page import="ex.ex12.emp.Emp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>ArrayList이용합니다.</title>
  <link rel="stylesheet" href="">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <style>
      .container {
          margin-top: 3em;
      }

      table, h4 {
          text-align: center;
      }
  </style>
</head>
<body>
<div class="container">

  <p>검색어를 입력하세요</p>
  <input class="form-control" id="myInput" type="search" placeholder="Search..">
  <%
    ArrayList<Emp> list = (ArrayList<Emp>) request.getAttribute("list");

    if (!list.isEmpty()) {
  %>
  <table class="table table-striped">
    <thead>
    <tr>
      <th>사원번호</th>
      <th>사원이름</th>
      <th>직급</th>
      <th>매니저</th>
      <th>입사일자</th>
      <th>급여</th>
      <th>커미션</th>
      <th>부서번호</th>
    </tr>
    </thead>
    <tbody id="myTable">
    <%
      for (Emp emp : list) {
    %>
    <tr>
      <td><%=emp.getEmpno()%>
      </td>
      <td><%=emp.getEname()%>
      </td>
      <td><%=emp.getJob()%>
      </td>
      <td><%=emp.getMgr()%>
      </td>
      <td><%=emp.getHiredate()%>
      </td>
      <td><%=emp.getSal()%>
      </td>
      <td><%=emp.getComm()%>
      </td>
      <td><%=emp.getDeptno()%>
      </td>
    </tr>
    <%
      }
    %>
    </tbody>
  </table>
  <%
    } else {
      out.print("<h4>조회된 데이터가 없습니다.</h4>");
    }
  %>
</div>
<script>
    $(document).ready(function () {
        $("#myInput").on("keyup", function () {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function () {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });
</script>
</body>
</html>

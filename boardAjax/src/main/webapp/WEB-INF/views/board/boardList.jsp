<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <jsp:include page="header.jsp"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js">
  <script src="${pageContext.request.contextPath}/js/list.js"></script>
  <style>
      select.form-control {
          width: auto;
          margin-bottom: 2em;
          display: inline-block;
      }

      .rows {
          text-align: right;
      }

      .gray {
          color: gray;
      }

      body > div > table > thead > tr:nth-child(2) > th:nth-child(1) {
          width: 8%
      }

      body > div > table > thead > tr:nth-child(2) > th:nth-child(2) {
          width: 50%
      }

      body > div > table > thead > tr:nth-child(2) > th:nth-child(3) {
          width: 14%
      }

      body > div > table > thead > tr:nth-child(2) > th:nth-child(4) {
          width: 17%
      }

      body > div > table > thead > tr:nth-child(2) > th:nth-child(5) {
          width: 11%
      }
  </style>
  <title>MVC 게시판</title>
</head>
<body>
<div class="container">

  <%-- 게시글이 있는 경우 --%>
  <c:if test="${listcount > 0}">
    <div class="rows">
      <span>줄보기</span>
      <select class="form-control" id="viewcount">
        <option value="1">1</option>
        <option value="3">3</option>
        <option value="5">5</option>
        <option value="7">7</option>
        <option value="10" selected>10</option>
      </select>
    </div>
    <table class="table table-striped">
      <thead>
      <tr>
        <th colspan="3">MVC 게시판 - list</th>
        <th colspan="2">
          <span>글 개수 : ${listcount}</span>
        </th>
      </tr>
      <tr>
        <th>
          <div>번호</div>
        </th>
        <th>
          <div>제목</div>
        </th>
        <th>
          <div>작성자</div>
        </th>
        <th>
          <div>날짜</div>
        </th>
        <th>
          <div>조회수</div>
        </th>
      </tr>
      </thead>
      <tbody>
      <c:set var="num" value="${listcount-(page-1)*limit}"/>
      <c:forEach var="b" items="${boardlist}">
        <tr>
          <td> <%-- 번호 --%>
            <c:out value="${num}"/> <%-- num 출력 --%>
            <c:set var="num" value="${num-1}"/> <%-- num=num-1; 의미 --%>
          </td>
          <td> <%-- 제목 --%>
            <div>
                <%-- 답변글 제목앞에 여백 처리 부분 --%>
              <c:if test="${b.board_re_lev > 0}"> <%-- 답글인 경우 --%>
                <c:forEach var="a" begin="0" end="${b.board_re_lev*2}" step="1">
                  &nbsp;
                </c:forEach>
                <img src="${pageContext.request.contextPath}/image/line.gif">
              </c:if>

              <a href="detail?num=${b.board_num}">
                <c:if test="${b.board_subject.length() >= 20}">
                  <c:out value="${b.board_subject.substring(0,20)}..."/>
                </c:if>
                <c:if test="${b.board_subject.length() < 20}">
                  <c:out value="${b.board_subject}"/>
                </c:if>
              </a>[${b.cnt}]
            </div>
          </td>
          <td>
            <div>${b.board_name}</div>
          </td>
          <td>
            <div>${b.board_date}</div>
          </td>
          <td>
            <div>${b.board_readcount}</div>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

    <div class="center-block">
      <ul class="pagination justify-content-center">
        <li class="page-item">
          <a ${page > 1 ? 'href=list?page=' += (page - 1) : ''}
                  class="page-link ${page <= 1 ? 'gray' : ''}">
            이전&nbsp;
          </a>
        </li>
        <c:forEach var="a" begin="${startpage}" end="${endpage}">
          <li class="page-item ${a == page ? 'active' : ''}">
            <a ${a == page ? '' : 'href=list?page=' += a}
                    class="page-link">${a}</a>
          </li>
        </c:forEach>
        <li class="page-item">
          <a ${page < maxpage ? 'href=list?page=' += (page + 1) : ''}
          class="page-link ${page >= maxpage ? 'gray' : ''}">&nbsp;다음</a>
        </li>
      </ul>
    </div>
  </c:if> <%-- <c:if test="${listcount > 0}"> end --%>

  <%-- 게시글이 없는 경우 --%>
  <c:if test="${listcount == 0}">
    <h3 style="text-align: center">등록된 글이 없습니다.</h3>
  </c:if>

  <button type="button" class="btn btn-info float-right">글 쓰 기</button>
</div> <%-- <div class="container"> end --%>
</body>
</html>

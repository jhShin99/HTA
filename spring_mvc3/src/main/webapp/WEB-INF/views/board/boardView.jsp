<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>MVC 게시판 - view</title>
  <jsp:include page="header.jsp"/>
  <script src="${pageContext.request.contextPath}/js/view.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/view.css">
  <script>
    const result = "${result}";
    if (result == 'passFail') {
        alert("비밀번호가 일치하지 않습니다.");
    }
  </script>
</head>
<body>
<input type="hidden" id="loginid" value="${id}" name="loginid"> <%-- view.js에서 사용하기 위해 추가합니다. --%>
<div class="container">
  <table class="table">
    <tr>
      <th colspan="2">MVC 게시판-view페이지</th>
    </tr>
    <tr>
      <td>
        <div>글쓴이</div>
      </td>
      <td>
        <div>${boarddata.BOARD_NAME}</div>
      </td>
    </tr>
    <tr>
      <td>
        <div>제목</div>
      </td>
      <td><c:out value="${boarddata.BOARD_SUBJECT}"/></td>
    </tr>
    <tr>
      <td>
        <div>내용</div>
      </td>
      <td style="padding-right: 0px">
        <textarea class="form-control" rows="5" readonly>${boarddata.BOARD_CONTENT}</textarea>
      </td>
    </tr>

    <c:if test="${boarddata.BOARD_RE_LEV==0}">
      <%-- 원문글인 경우에만 첨부파일을 추가 할 수 있습니다. --%>
      <tr>
        <td>
          <div>첨부파일</div>
        </td>
          <%-- 파일을 첨부한 경우 --%>
        <c:if test="${!empty boarddata.BOARD_FILE}">
          <td><img src="/image/down.png" width="10px">
            <form method="post" action="down" style="height: 0px">
              <input type="hidden" value="${boarddata.BOARD_FILE}" name="filename">
              <input type="hidden" value="${boarddata.BOARD_ORIGINAL}" name="original">
              <input type="submit" value="${boarddata.BOARD_ORIGINAL}">
            </form>
          </td>
        </c:if>
        <%--<c:if test="${!empty boarddata.BOARD_FILE}">
          <td>
            <img src="${pageContext.request.contextPath}/image/down.png" width="10px">
            <a href="down?filename=${boarddata.BOARD_FILE}">${boarddata.BOARD_FILE}</a>
          </td>
        </c:if>
--%>
          <%-- 파일을 첨부하지 않은 경우 --%>
        <c:if test="${empty boarddata.BOARD_FILE}">
          <td></td>
        </c:if>
      </tr>
    </c:if>

    <tr>
      <td colspan="2" class="center">
        <button class="btn btn-primary">댓글</button>
        <span id="count">${count}</span>

        <c:if test="${boarddata.BOARD_NAME == id || id == 'admin'}">
          <a href="modifyView?num=${boarddata.BOARD_NUM}">
            <button class="btn btn-info">수정</button>
          </a>
          <%-- href의 주소를 #으로 설정합니다. --%>
          <a href="#">
            <button class="btn btn-danger" data-toggle="modal" data-target="#myModal">삭제</button>
          </a>
        </c:if>

        <a href="replyView?num=${boarddata.BOARD_NUM}">
          <button class="btn btn-info">답변</button>
        </a>
        <a href="list">
          <button class="btn btn-success">목록</button>
        </a>
      </td>
    </tr>
  </table>
  <%-- modal 시작 --%>
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-body">
          <form name="deleteForm" action="delete" method="post">
            <%-- http://localhost:8088/Board_Ajax/boards/detail?num=22
                 주소를 보면 num을 파라미터로 넘기고 있습니다.
                 이 값을 가져와서 ${param.num}를 사용 또는 ${boarddata.board_num}
            --%>
            <input type="hidden" name="num" value="${param.num}" id="comment_board_num">
            <div class="form-group">
              <label for="board_pass">비밀번호</label>
              <input type="password"
                     class="form-control" placeholder="Enter password"
                     name="BOARD_PASS" id="board_pass">
            </div>
            <button type="submit" class="btn btn-primary">전송</button>
            <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
          </form>
        </div>
      </div>
    </div>
  </div>
  <%-- modal 끝 --%>

  <div id="comment">
    <button class="btn btn-info float-left">총 50자까지 가능합니다.</button>
    <button id="write" class="btn btn-info float-right">등록</button>
    <textarea rows="3" class="form-control" id="content" maxlength="50"></textarea>
    <table class="table">
      <thead>
      <tr><td>아이디</td><td>내용</td><td>날짜</td></tr>
      </thead>
      <tbody></tbody>
    </table>
    <div id="message"></div>
  </div>
</div>
</body>
</html>

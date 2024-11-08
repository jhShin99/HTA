<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
  <jsp:include page="../board/header.jsp"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/memberList.css">
  <!--
    1. 검색어를 입력한 후 다시 list으로 온 경우 검색 필드와 검색어가 나타나도록 합니다.
   -->
  <script>
    $(function() {
        //검색 클릭 후 응답화면에는 검색시 선택한 필드가 선택되도록 합니다.
        let selectedValue = '${search_field}';
        if (selectedValue != '-1') {
            $("#viewcount").val(selectedValue);//선택된 필드가 없는 경우 기본적으로 아이디를 선택하도록 합니다.
        } else {
            selectedValue = 0;
        }

        //검색 후 selectedValue값에 따라 placeholder가 나타나도록 합니다.
        const message = ["아이디", "이름", "나이", "여 또는 남"];
        const $input = $(".input-group input");
        $input.attr("placeholder", message[selectedValue] + " 입력하세요");

        //검색 버튼 클릭한 경우
        $("button").click(function() {
            //검색어 공백 유효성 검사합니다.
            const word = $input.val();
            if (word == '') {
                alert("검색어를 입력하세요");
                $input.focus();
                return false;
            }

            if (selectedValue == 2) {
                const pattern = /^[0-9]{2}$/;
                if (!pattern.test(word)) {
                    alert("나이는 형식에 맞게 입력하세요(두자리 숫자)");
                    return false;
                }
            } else if (selectedValue == 3) {
                if (word != "남" && word != "여") {
                    alert("남 또는 여를 입력하세요");
                    return false;
                }
            }
        }); //button click end

        //검색어 입력창에 placeholder 나타나도록 합니다.
        $("#viewcount").change(function() {
            selectedValue = $(this).val();
            $input.val('').attr("placeholder", message[selectedValue] + " 입력하세요");
        }) //$("#viewcount").change end

        //회원 목록의 삭제를 클릭한 경우
        $("tr > td:nth-child(3) > a").click(function(event) {
            const answer = confirm("정말 삭제하시겠습니까?");
            console.log(answer); //취소를 클릭한 경우 - false
            if (!answer) { //취소를 클릭한 경우
                event.preventDefault(); //이동하지 않습니다.
            }
        }) // 삭제 클릭 end
    }) //ready end
  </script>
</head>
<body>
<c:if test="${listcount > 0}">
  <div class="container">
    <form action="list" method="post">
      <div class="input-group">
        <select id="viewcount" name="search_field">
          <option value="0" selected>아이디</option>
          <option value="1">이름</option>
          <option value="2">나이</option>
          <option value="3">성별</option>
        </select>
        <input name="search_word" type="text" class="form-control"
               placeholder="아이디 입력하세요" value="${search_word}">
        <button class="btn btn-primary" type="submit">검색</button>
      </div>
    </form>

    <table class="table table-striped">
      <caption style="font-weight: bold">회원목록</caption>
      <thead>
      <tr>
        <th colspan="2">MVC 게시판 - 회원정보 list</th>
        <th><span>회원 수 : ${listcount}</span></th>
      </tr>
      <tr>
        <td>아이디</td>
        <td>이름</td>
        <td>삭제</td>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="m" items="${totallist}">
        <tr>
          <td><a href="info?id=${m.id}">${m.id}</a></td>
          <td>${m.name}</td>
          <td><a href="delete?id=${m.id}">삭제</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    <div>
      <ul class="pagination justify-content-center">
        <c:if test="${page > 1}">
          <li class="page-item">
            <a href="list?page=${page-1}&search_field=${search_field}&search_word=${search_word}"
               class="page-link">이전</a>&nbsp;
          </li>
        </c:if>

        <c:forEach var="a" begin="${startpage}" end="${endpage}">
          <c:if test = "${a == page}">
            <li class="page-item active">
              <a class="page-link">${a}</a>
            </li>
          </c:if>
          <c:if test="${a != page}">
            <c:url var="go" value="list">  <!-- 위의 a 태그를 다르게 사용하는 방법 -->
              <c:param name="page" value="${a}"/>
              <c:param name="search_field" value="${search_field}"/>
              <c:param name="search_word" value="${search_word}"/>
            </c:url>
            <li class="page-item">
              <a href="${go}" class="page-link">${a}</a>
            </li>
          </c:if>
        </c:forEach>

        <c:if test="${page < maxpage}">
          <c:url var="next" value="list">
            <c:param name="page" value="${page+1}"/>
            <c:param name="search_field" value="${search_field}"/>
            <c:param name="search_word" value="${search_word}"/>
          </c:url>
          <li class="page-item">
            <a href="${next}" class="page-link">&nbsp;다음</a>
          </li>
        </c:if>
      </ul>
    </div>
  </div>
</c:if>

<%-- 회원이 없는 경우 --%>
<c:if test="${listcount == 0 && empty search_word}">
  <h1>회원이 없습니다.</h1>
</c:if>
<c:if test="${listcount == 0 && !empty search_word}">
  <h1>검색 결과가 없습니다.</h1>
</c:if>
</body>
</html>

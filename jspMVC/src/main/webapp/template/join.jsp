<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
1. <input type="button" value="ID중복검사"> 태그에 id="idcheck" 추가합니다.
2. submit 당시 ID 중복검사 안한 경우 중복검사하도록 메시지 출력합니다.
-->

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Document</title>
  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> <!-- 주소찾기 api -->
  <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/validate.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/join.css">
  <style>
    #opener_message {
        margin-top: -10px;
        margin-bottom: 10px;
    }
  </style>
</head>
<body>
<div class="container">
  <form name="myForm" method="post" action="joinProcess.net" id="myForm">
    <fieldset>
      <legend>회원가입</legend>
      <label for="id">ID</label>
      <div>
        <input type="text" placeholder="Enter id" name="id" id="id" />
        <input type="button" value="ID중복검사" id="idcheck"/>
        <div id="opener_message"></div><input type="hidden" id="result">
      </div>

      <label for="pass">Password</label>
      <input
              type="password"
              placeholder="Enter Password"
              name="pass"
              id="pass"
      />

      <label for="jumin1">주민번호</label>
      <input
              type="text"
              placeholder="주민번호 앞자리"
              maxlength="6"
              name="jumin1"
              id="jumin1"
      />
      <b> - </b>
      <input
              type="text"
              placeholder="주민번호 뒷자리"
              maxlength="7"
              name="jumin2"
              id="jumin2"
      />

      <label for="email">E-Mail</label>
      <input type="text" name="email" id="email" />@
      <input type="text" name="domain" id="domain" />
      <select name="sel" id="sel">
        <option value="">직접입력</option>
        <option value="naver.com">naver.com</option>
        <option value="daum.net">daum.net</option>
        <option value="nate.com">nate.com</option>
        <option value="gmail.com">gmail.com</option>
      </select>

      <label>성별</label>
      <div class="container2">
        <input type="radio" name="gender" value="m" id="gender1" />남자
        <input type="radio" name="gender" value="f" id="gender2" />여자
      </div>

      <label>취미</label>
      <div class="container2">
        <input type="checkbox" name="hobby" id="hobby1" value="공부" />공부
        <input type="checkbox" name="hobby" id="hobby2" value="게임" />게임
        <input type="checkbox" name="hobby" id="hobby3" value="운동" />운동
        <input type="checkbox" name="hobby" id="hobby4" value="등산" />등산
        <input type="checkbox" name="hobby" id="hobby5" value="낚시" />낚시
      </div>

      <label for="post1">우편번호</label>
      <input type="text" size="5" maxlength="5" name="post1" id="post1" readonly/>
      <input type="button" value="우편검색" id="postcode"/>

      <label for="address">주소</label>
      <input type="text" size="50" name="address" id="address" />
      <label for="intro">자기소개</label>
      <textarea rows="10" name="intro" id="intro" maxlength="100"></textarea>

      <div class="clearfix">
        <button type="submit" class="signupbtn">회원가입</button>
        <button type="reset" class="cancelbtn">취소</button>
      </div>
    </fieldset>
  </form>
</div>
</body>
</html>

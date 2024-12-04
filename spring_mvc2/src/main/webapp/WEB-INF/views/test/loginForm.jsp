
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Document</title>
  <script src="js/jquery-3.7.1.min.js"></script>
  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> <!-- 주소찾기 api -->
  <style>
      body {
          font-family: Arial, Helvetica, sans-serif;
      }

      * {
          box-sizing: border-box;
      }

      select,
      input[type="text"],
      input[type="password"],
      input[type="button"] {
          width: 100%;
          padding: 15px;
          margin: 5px 0 22px 0;
          display: inline-block;
          border: none;
          background: #f1f1f1;
          outline: none;
          height: 40px;
          border-radius: 5px;
      }

      select {
          padding: 10px 15px 10px 15px;
          vertical-align: bottom;
      }

      fieldset {
          border-radius: 8px;
      }

      legend {
          text-align: center;
          font-size: 40px;
          font-weight: bold;
      }

      #id,
      #post1 {
          width: 70%;
      }

      #jumin1,
      #jumin2 {
          width: 49%;
      }

      #id + input,
      #post1 + input {
          width: 29%;
          background: orange;
          line-height: 10px;
          vertical-align: bottom;
      }

      textarea {
          width: 100%;
          resize: none;
          outline: none;
          margin-top: 5px;
          border: 2px solid lightgray;
      }

      #email,
      #domain {
          width: 33%;
      }

      #sel {
          width: 30%;
          background: lightgray;
      }

      .container2 {
          border: 1px solid lightgray;
          padding: 1.5% 1%;
          word-spacing: 10px;
          margin-bottom: 20px;
      }

      input[type="text"]:focus,
      input[type="password"]:focus {
          background-color: #ddd;
          outline: none;
      }

      input[type="button"]:hover {
          opacity: 0.8;
          cursor: pointer;
      }

      button {
          background-color: #4caf50;
          color: white;
          padding: 14px 20px;
          margin: 8px 0;
          border: none;
          cursor: pointer;
          width: 100%;
          opacity: 0.9;
      }

      button:hover {
          opacity: 1;
      }

      .cancelbtn {
          padding: 14px 20px;
          background-color: #f44336;
      }

      .cancelbtn,
      .signupbtn {
          float: left;
          width: 50%;
      }

      body {
          background-color: #f5f5f5;
      }

      #myForm {
          background-color: #fefefe;
          margin: 5% auto 15% auto;
          width: 850px;
          padding: 16px;
          border-radius: 8px;
          box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
      }

      label {
          display: block;
          font-weight: bold;
          margin: 15px 0 5px;
      }
  </style>
</head>
<body>
<div class="container">
  <form name="myForm" method="post" action="joinProcess" id="myForm">
    <fieldset>
      <legend>유효성 검사</legend>
      <label for="id">ID</label>
      <div>
        <input type="text" placeholder="Enter id" name="id" id="id" />
        <input type="button" value="ID중복검사" id="idcheck"/>
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
      <input type="text" size="5" maxlength="5" name="post1" id="post1" />
      <input type="button" value="우편검색" id="postcode"/>

      <label for="address">주소</label>
      <input type="text" size="50" name="address" id="address" />
      <label for="intro">자기소개</label>
      <textarea rows="10" name="intro" id="intro"></textarea>

      <div class="clearfix">
        <button type="submit" class="signupbtn">회원가입</button>
        <button type="reset" class="cancelbtn">취소</button>
      </div>
    </fieldset>
  </form>
</div>
<script>
    $(document).ready(function () {
        //추가된 곳
        let idcheckValue = ""; // id 중복 검사 때 사용한 값으로 정규식 통과한 값을 저장

        //회원가입 버튼 클릭할때 이벤트 처리 부분
        $("#myForm").submit(function () {
            const id = $("#id");
            if (id.val().trim() == "") {
                alert("ID를 입력 하세요");
                id.focus();
                return false;
            }

            //추가된 곳
            if(id.val().trim() != idcheckValue) {
                alert("ID 중복검사 하세요");
                return false;
            }

            const pass = $("#pass");
            if (pass.val().trim() == "") {
                alert("비밀번호를 입력 하세요");
                pass.focus();
                return false;
            }

            const jumin1 = $("#jumin1");
            if (jumin1.val().trim() == "") {
                alert("주민번호 앞자리를 입력 하세요");
                jumin1.focus();
                return false;
            }

            if (jumin1.val().trim().length != 6) {
                alert("주민번호 앞자리 6자리를 입력 하세요");
                jumin1.val("").focus();
                return false;
            }

            if (!$.isNumeric(jumin1.val().trim())) {
                alert("주민번호 앞자리 6자리는 숫자만 입력 가능 합니다.");
                jumin1.val("").focus();
                return false;
            }

            const jumin2 = $("#jumin2");
            if (jumin2.val().trim() == "") {
                alert("주민번호 뒷자리를 입력 하세요");
                jumin2.focus();
                return false;
            }

            if (jumin2.val().trim().length != 7) {
                alert("주민번호 뒷자리 7자리를 입력 하세요");
                jumin2.val("").focus();
                return false;
            }

            if (!$.isNumeric(jumin2.val().trim())) {
                alert("주민번호 뒷자리 7자리는 숫자만 입력 가능합니다.");
                jumin2.val("").focus();
                return false;
            }

            const email = $("#email");
            if (email.val().trim() == "") {
                alert("E-Mail 아이디를 입력 하세요");
                email.focus();
                return false;
            }

            const domain = $("#domain");
            if (domain.val().trim() == "") {
                alert("E-mail 도메인을 입력하세요");
                domain.focus();
                return false;
            }

            let cnt = $("input:radio:checked").length;
            if (cnt == 0) {
                alert("남, 여 중에서 1개를 선택하세요");
                return false;
            }

            cnt = $("input:checkbox:checked").length;
            if (cnt < 2) {
                alert("취미는 2개이상 선택하세요");
                return false;
            }

            const post1 = $("#post1");
            if (post1.val().trim() == "") {
                alert("우편번호를 입력 하세요");
                post1.focus();
                return false;
            }

            if (!$.isNumeric(post1.val())) {
                alert("우편번호는 숫자만 입력 가능 합니다.");
                post1.val("").focus();
                return false;
            }

            const address = $("#address");
            if (address.val().trim() == "") {
                alert("주소를 입력 하세요");
                address.focus();
                return false;
            }

            const intro = $("#intro");
            if (intro.val().trim() == "") {
                alert("자기소개를 입력 하세요");
                intro.focus();
                return false;
            }
        });

        // ID 중복 검사 부분
        $("#idcheck").click(function () {
            const id = $("#id");
            const idValue = id.val().trim();
            if (idValue == "") {
                alert("ID를 입력 하세요");
                id.focus();
                return false;
            } else {
                // 첫글자는 대문자이고 두번째부터는 대소문자, 숫자, _로 총 4개 이상
                const pattern = /^[A-Z][a-zA-Z0-9_]{3,}$/;
                if (pattern.test(idValue)) {

                    //추가된 곳
                    idcheckValue = idValue;

                    const ref = `idcheck.html?id=${idValue}`;
                    window.open(ref, "idcheck", "width=350, height=200");
                } else {
                    alert("첫글자는 대문자이고 두번째부터는 대소문자, 숫자, _로 총 4개 이상이어야 합니다.");
                    id.val('').focus();
                }
            }
        });

        //우편검색 버튼 클릭
        $("#postcode").click(
            Postcode
        );

        //도메인 선택 부분
        $("#sel").change(function() {
            const domain = $("#domain");
            if ($(this).val() == "") { //직접입력 선택한 경우
                domain.val("").focus().prop("readOnly", false);
            } else { // 도메인 선택한 경우
                domain.val($(this).val()).prop("readOnly", true);
            }
        });

        //성별 선택하지 못하도록 합니다.
        $('input[name="gender"]').click(function() {
            return false;
        });

        $("#jumin1").keyup(function() {
            const jumin1Value = $(this).val().trim();
            if (jumin1Value.length == 6) {
                const pattern = /^[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])$/;
                if (pattern.test(jumin1Value)) {
                    $("#jumin2").focus(); //주민번호 뒷자리로 포커스 이동
                } else {
                    alert("숫자 또는 형식에 맞게 입력하세요[yymmdd]");
                    $(this).val('').focus();
                }
            }
        });

        $("#jumin2").keyup(function() {
            const jumin2Value = $(this).val().trim();
            if (jumin2Value.length == 7) {
                const pattern = /^[1234][0-9]{6}$/;
                if (pattern.test(jumin2Value)) {
                    const c = Number(jumin2Value.substring(0,1));
                    const index = (c - 1) % 2; // c=1,3이면 index=0
                                               // c=2,4이면 index=1
                    $("input[name=gender]").eq(index).prop("checked", true);
                } else {
                    alert("형식에 맞게 입력하세요[1234][0-9]{6}");
                    $(this).val('').focus();
                }
            } else {
                $('#gender1', '#gender2').prop('checked', false);
            }
        })

        //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
        function Postcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    console.log(data.zonecode)
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                    var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraRoadAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraRoadAddr !== ''){
                        extraRoadAddr = ' (' + extraRoadAddr + ')';
                    }
                    // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                    if(fullRoadAddr !== ''){
                        fullRoadAddr += extraRoadAddr;
                    }


                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    $('#post1').val(data.zonecode);
                    $('#address').val(fullRoadAddr);
                }
            }).open();
        }//function Postcode()
    });
</script>
</body>
</html>

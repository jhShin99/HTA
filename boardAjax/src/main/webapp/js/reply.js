$(document).ready(function() {

    //submit 버튼 클릭할 때 이벤트 부분
    $("form[name=replyform]").submit(function() {
        const $board_subject = $("#board_subject");
        if ($board_subject.val().trim() === "") {
            alert("제목을 입력하세요");
            $board_subject.focus();
            return false;
        }

        const $board_content = $("#board_content");
        if ($board_content.val().trim() === "") {
            alert("내용을 입력하세요");
            $board_content.focus();
            return false;
        }

        const $board_pass = $("input:password");
        if ($board_pass.val().trim() === "") {
            alert("비밀번호를 입력하세요");
            $board_pass.focus();
            return false;
        }
    })
})
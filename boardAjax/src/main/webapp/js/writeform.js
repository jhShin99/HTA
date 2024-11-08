$(document).ready(function() {

    $("#upfile").change(function() {
        console.log($(this).val()) //c:\fakepath\upload.png
        const inputfile = $(this).val().split('\\');
        $("#filevalue").text(inputfile[inputfile.length - 1]);
    });

    //submit 버튼 클릭할 때 이벤트 부분
    $("form[name=boardform]").submit(function() {
        const $boardPass = $("#board_pass");
        if ($boardPass.val().trim() == "") {
            alert("비밀번호를 입력하세요");
            $boardPass.focus();
            return false;
        }

        const $boardSubject = $("#board_subject");
        if ($boardSubject.val().trim() == "") {
            alert("제목을 입력하세요");
            $boardSubject.focus();
            return false;
        }

        const $boardContent = $("#board_content");
        if ($boardContent.val().trim() == "") {
            alert("내용을 입력하세요");
            $boardContent.focus();
            return false;
        }
    }); //submit end
}); //ready() end
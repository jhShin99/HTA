$(function () {
    $("#comment table").hide();
    let page = 1;
    const count = parseInt($("#count").text());

    if (count != 0) { // 댓글 개수가 0이 아니면
        getList(1); // 첫 페이지의 댓글을 구해 옵니다. (한 페이지에 3개씩 가져옵니다.)
    } else { //댓글이 없는 경우
        $("#message").text("등록된 댓글이 없습니다.");
    }

    function getList(currentPage) {
        $.ajax({
            type: "post",
            url: "../comment/list",
            data: {
                "board_num": $("#board_num").val(),
                "page": currentPage
            },
            dataType: "json",
            success: function (rdata) {
                $("#count").text(rdata.listcount);
                if (rdata.listcount > 0) {
                    $("#comment table").show(); //문서가 로딩될 때 hide() 했던 부분을 보이게 합니다. (1)
                    $("#comment tbody").empty();
                    $(rdata.list).each(function () {
                        let output = '';
                        let img = '';
                        if ($("#loginid").val() == this.id) {
                            img = "<img src='../image/pencil2.png' width='15px' class='update'>"
                                + "<img src='../image/delete.png' width='15px' class='remove'>"
                                + "<input type='hidden' value='" + this.num + "'>";
                        }
                        output += "<tr><td>" + this.id + "</td>";

                        // XSS(Cross-Site Scripting): 권한이 없는 사용자가 웹 사이트에 스크립트를 삽입하는 공격 기법
                        // 이것을 방지 하기 위한 방법으로 2번처럼 <td></td> 영역을 만든 뒤 3번에서 text() 안에
                        // this.content를 넣어 스크립트를 문자열로 만듭니다.
                        output += "<td></td>"; //2

                        //2번과 3번을 이용하지 않고 4번을 이용하면 내용에 스크립트가 있는 경우 스크립트 실행됩니다.
                        //output += "<td>" + this.content + "</td>; //4
                        output += "<td>" + this.reg_date + img + "</td></tr>";
                        $("#comment tbody").append(output);

                        //append한 마지막 tr의 2번째 자식 td를 찾아 text() 메서드로 content를 넣습니다.
                        $("#comment tbody tr:last").find("td:nth-child(2)").text(this.content); //3
                    }); // each end

                    if (rdata.listcount > rdata.list.length) { // 전체 댓글 개수 > 현재까지 보여준 댓글 개수
                        $("#message").text("더보기");
                    } else {
                        $("#message").text("");
                    }
                } else {
                    $("#message").text("등록된 댓글이 없습니다.");
                    $("#comment tbody").empty();
                    $("#comment table").hide();
                }
            }
        }); // ajax end
    } // function end
})


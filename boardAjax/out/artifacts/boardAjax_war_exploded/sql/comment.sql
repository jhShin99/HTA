drop table comm cascade constraints purge;

create table comm (
    num number primary key,
    id varchar2(30) references member(id) on delete cascade,
    content varchar2(200),
    reg_date date,
    comment_board_num number references board(board_num) on delete cascade, -- comm 테이블이 참조
    comment_re_lev number(1) check(comment_re_lev in (0,1,2)), --원문이면 0 답글이면 1
    comment_re_seq number, -- 원문이면 0
    comment_re_ref number -- 원문은 자신 글번호, 답글이면 원문 글번호
);
-- 게시판 글이 삭제되면 참조하는 댓글도 삭제됩니다.

drop sequence com_seq;

--시퀀스를 생성합니다.
create sequence com_seq;

-- 1. comm 테이블에서 comment_board_num에 해당하는 로우 개수를 구합니다.
select count(*)
from comm
where comment_board_num = ?;

--2. member에 있는 memberfile이 필요합니다.
-- 조건1) order by comment_re_ref asc, comment_re_seq asc (등록순)
-- 조건2) order by comment_re_ref desc, comment_re_seq asc (최신순)

select comm.*, member.memberfile
from comm inner join member
on comm.id = member.id
where comment_board_num = ?
order by comment_re_ref %s,
         comment_re_seq asc
-- 조건1) 등록순으로 정렬합니다.


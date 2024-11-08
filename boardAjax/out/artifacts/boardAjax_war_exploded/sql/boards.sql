drop table board cascade constraints purge;

--JDBC BOARD가 있으므로 알아서 잘 하기
CREATE TABLE BOARDS
(
    BOARD_NUM  NUMBER,       -- 글 번호
    BOARD_NAME VARCHAR2(30), --작성자
    BOARD_PASS VARCHAR2(30), -- 비밀번호
    BOARD_SUBJECT VARCHAR2(300), --제목
    BOARD_CONTENT VARCHAR2(4000), --내용
    BOARD_FILE VARCHAR2(50), --첨부될 파일 명
    BOARD_RE_REF NUMBER, --답변 글 작성시 참조되는 글의 번호
    BOARD_RE_LEV NUMBER, --답변 글의 깊이
    BOARD_RE_SEQ NUMBER, --답변 글의 순서
    BOARD_READCOUNT NUMBER, -- 글의 조회수
    BOARD_DATE DATE default sysdate, -- 글의 작성 날짜
    PRIMARY KEY(BOARD_NUM)
);

-- 게시글에 달린 댓글의 개수를 구하기 위한 과정입니다.
select * from board;
delete from boards;
select * from comm;

insert into boards (BOARD_NUM, BOARD_SUBJECT, BOARD_NAME, BOARD_RE_REF)
values(1, '처음', 'admin', 1);

insert into boards (BOARD_NUM, BOARD_SUBJECT, BOARD_NAME, BOARD_RE_REF)
values(2, '둘째', 'admin', 2);

insert into boards (BOARD_NUM, BOARD_SUBJECT, BOARD_NAME, BOARD_RE_REF)
values(3, '셋째', 'admin', 3);

-- admin 계정이 있어야 삽입됨
insert into comm (num, id, comment_board_num) values (1, 'admin', 1);
insert into comm (num, id, comment_board_num) values (2, 'admin', 1);
insert into comm (num, id, comment_board_num) values (3, 'admin', 2);
insert into comm (num, id, comment_board_num) values (4, 'admin', 2);

update boards
set board_subject = '오늘도 행복하세요'
where board_num = 1;


-- 1. comm 테이블에서 comment_board_num 별 개수를 구합니다.
-- COMMENT_BOARD_NUM  CNT
-- 1                  2
-- 2                  2


select comment_board_num, count(*) cnt
from COMM
group by comment_board_num;

--2. board와 조인을 합니다.
-- BOARD_NUM  BOARD_SUBJECT  CNT
-- 1          오늘도 행복하세요  2
-- 2          둘째             2

select board_num, board_subject, cnt
from boards join (select comment_board_num, count(*) cnt
                 from COMM
                 group by comment_board_num)
on board_num = comment_board_num;

-- 문제점) 만약 board 테이블에는 글이 있지만 댓글이 없는 경우 조회가 되지 않습니다.

-- 3. outer join을 이용해서 board의 글이 모두 표시되고 cnt가 null인 경우 0으로 표시되도록 합니다.
-- BOARD_NUM   BOARD_SUBJECT   CNT
-- 3           셋째             0
-- 2           둘째             2
-- 1           오늘도 행복하세요  2

-- 1단계) 게시판 글에 댓글이 없는 경우 cnt가 null입니다.
select board_num, board_subject, cnt
from boards left outer join (select comment_board_num, count(*) cnt
                            from comm
                            group by comment_board_num)
on board_num = comment_board_num;

-- BOARD_NUM   BOARD_SUBJECT   CNT
-- 1           오늘도 행복하세요  2
-- 2           둘째             2
-- 3           셋째             NULL

--2단계) cnt가 null인 경우 0으로 만들어요
select board_num, board_subject, nvl(cnt, 0) as cnt
from boards left outer join (select comment_board_num, count(*) cnt
                            from comm
                            group by comment_board_num)
on board_num = comment_board_num
order by BOARD_RE_REF desc, BOARD_RE_SEQ asc;

----------------------------------------------------------------------

--4. 인라인 뷰를 이용한 쿼리문 작성
-- select *
-- from (select rownum rnum, j.*
--       from (
--                 3번
--            ) j
--       where rownum <= 10)
-- where rnum>=1 and rnum<=10;


--5.
select *
from (select rownum rnum, j.*
      from (
               select boards.*, nvl(cnt,0) as cnt
               from boards left outer join (select comment_board_num, count(*) cnt
                                           from comm
                                           group by comment_board_num)
               on board_num = comment_board_num
               order by BOARD_RE_REF desc,
               BOARD_RE_SEQ asc
           ) j
      where rownum <= 10)
where rnum>=1 and rnum<=10;

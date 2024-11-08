drop table member cascade constraints purge;
--1. index.jsp에서 시작합니다.
--2. 관리자 계정 admin, 비번 1234를 만듭니다.
--3. 사용자 계정을 3개 만듭니다.

create table member(
    id  varchar2(12),
    password varchar2(10),
    name varchar2(15),
    age number(2),
    gender varchar2(3), -- 남, 여
    email varchar2(30), --hta@hta.com
    memberfile varchar2(50),
    primary key(id)
);

--memberfile은 회원 정보 수정시 적용합니다.

--admin 제외한 로우 개수
select count(*) from MEMBER
where id != 'admin';

-- MemberDAO의 getListCount(String field, value) 메서드
--NAME의 값에 '홍길동'이 포함된 로우 개수
-- 필드에 ?를 넣으면 따옴표가 들어가서 오류남
-- select count(*) from MEMBER
-- where id != 'admin'
-- and ? like '%홍길동%';

-- select count(*) from MEMBER
-- where id != 'admin'
-- and 'name' like '%홍길동%'; <- 이렇게 바뀜

-- select count(*) from MEMBER
-- where id != 'admin'
-- and %s like '%홍길동%';
select count(*) from MEMBER
where id != 'admin'
and ? like '%홍길동%';
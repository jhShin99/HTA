CREATE TABLE comments (
    num         NUMBER PRIMARY KEY,
    id          VARCHAR2(30) REFERENCES member(id),
    content     VARCHAR2(200),
    reg_date    DATE,
    BOARD_NUM   NUMBER REFERENCES board(board_num) ON DELETE CASCADE
);

CREATE SEQUENCE com_seq;

SELECT * FROM comments;
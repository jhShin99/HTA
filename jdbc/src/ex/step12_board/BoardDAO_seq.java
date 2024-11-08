package ex.step12_board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO_seq {

    public List<Board> search(String nextLine) {
        String sql = "select * "
                + "from board "
                + "where board_subject like ? "
                + "or board_content like ? ";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        List<Board> list = new ArrayList<Board>();
        try (
                Connection conn = DriverManager.getConnection(url, "scott", "tiger");
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ) {
            pstmt.setString(1, "%" + nextLine + "%");
            pstmt.setString(2, "%" + nextLine + "%");

            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    Board board = new Board();
                    board.setBoard_num(rs.getInt("BOARD_NUM"));
                    board.setBoard_name(rs.getString("BOARD_NAME"));
                    board.setBoard_subject(rs.getString("BOARD_SUBJECT"));
                    board.setBoard_content(rs.getString("BOARD_CONTENT"));
                    board.setBoard_re_ref(rs.getInt("BOARD_RE_REF"));
                    board.setBoard_re_lev(rs.getInt("BOARD_RE_LEV"));
                    board.setBoard_date(rs.getString("BOARD_DATE"));
                    list.add(board);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("getBoardList() 에러 : " + ex);
        }
        return list;
    }

    public int count() {
        String sql = "select count(*) from board";
        int count = 0;
        try (
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
        ) {
            if (rs.next()) {
                count = rs.getInt("count(*)"); //조회시 첫번째 컬럼의 값을 가져옵니다.
                //count = rs.getInt(1);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("count() 에러 : " + ex);
        }
        return count;
    } //count() 메서드 end

    public int boardDelete(Board board) {
        String board_delete_sql =
                "delete from board "
                        + "          where BOARD_RE_REF = ?"
                        + "          and   BOARD_RE_LEV >= ?"
                        + "          and   BOARD_RE_SEQ >= ?"
                        + "          and   BOARD_RE_SEQ <= ("
                        + "                             nvl((SELECT min(board_re_seq)-1"
                        + "                                  FROM   BOARD  "
                        + "                                  WHERE  BOARD_RE_REF=? "
                        + "                                  AND    BOARD_RE_LEV=?"
                        + "                                  AND    BOARD_RE_SEQ>?) , "
                        + "                                  (SELECT max(board_re_seq) "
                        + "                                   FROM   BOARD  "
                        + "                                   WHERE  BOARD_RE_REF=? ))"
                        + "                             )";
        int result = 0;
        try (
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
                //PreparedStatement 객체 얻기
                PreparedStatement pstmt = conn.prepareStatement(board_delete_sql);
        ) {
            pstmt.setInt(1, board.getBoard_re_ref());
            pstmt.setInt(2, board.getBoard_re_lev());
            pstmt.setInt(3, board.getBoard_re_seq());
            pstmt.setInt(4, board.getBoard_re_ref());
            pstmt.setInt(5, board.getBoard_re_lev());
            pstmt.setInt(6, board.getBoard_re_seq());
            pstmt.setInt(7, board.getBoard_re_ref());

            // 쿼리 실행 후 삭제된 로우(레코드) 개수가 반환됩니다.
            result = pstmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("boardDelete() 에러: " + ex);
        }

        return result;
    }

    public int boardReply(Board board) {
        String sql1 = " update board "
                + "set    BOARD_RE_SEQ = BOARD_RE_SEQ + 1 "
                + "where  BOARD_RE_REF = ? "
                + "and    BOARD_RE_SEQ > ?";

        String sql2 = "insert into board "
                + "(BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,"
                + " BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF,"
                + " BOARD_RE_LEV, BOARD_RE_SEQ,"
                + " BOARD_READCOUNT,BOARD_DATE) "
                + "values(board_seq.nextval,?,?,?,?,?,?,?,?,?,sysdate)";

        int result = 0;
        /**
         * 선택한 글의 글 그룹 번호입니다.
         * 답변을 달게 되면 답변 글은 이 번호와 같은 관련글 번호를 갖게 처리되면서 같은 그룹에 속하게 됩니다.
         * 글 목록에서 보여줄때 하나의 그룹으로 묶여서 출력됩니다.
         */
        int re_ref = board.getBoard_re_ref();

        /**
         * 답변 글의 깊이를 의미합니다.
         * 선택한 글에 대한 답변 글이 출력될 때 한 번 들여쓰기 처리가 되고 답변 글에 대한 답변 글은 들여쓰기가 두 번 처리되게 합니다.
         * 선택한 글이 원문인 경우에는 이 값이 0이고 원문의 답변 글은 1, 답변 글의 답변 글은 2가 됩니다.
         */
        int re_lev = board.getBoard_re_lev();

        /**
         * 같은 관련 글 중에서 해당 글이 출력되는 순서입니다.
         */
        int re_seq = board.getBoard_re_seq();

        try (
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
        ) {
            // 트랜잭션을 이용하기 위해서 setAutoCommit을 false로 설정합니다.
            conn.setAutoCommit(false);

            /**
             * BOARD_RE_REF, BOARD_RE_SEQ 값을 확인하여 원문 글에 다른 답글이 있으면
             * 다른 답변 글들이 BOARD_RE_SEQ 값을 1씩 증가시킵니다.
             * 현재 글을 다른 답변 글보다 앞에 출력되게 하기 위해서입니다.
             */
            try (PreparedStatement pstmt1 = conn.prepareStatement(sql1)) {
                pstmt1.setInt(1, re_ref);
                pstmt1.setInt(2, re_seq);
                pstmt1.executeUpdate();

                //등록할 답변 글의 BOARD_RE_LEV, BOARD_RE_SEQ 값을 선택한 글보다 1씩 증가시킵니다.
                ++re_lev;
                ++re_seq;

                try (PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
                    pstmt2.setString(1, board.getBoard_name());
                    pstmt2.setString(2, board.getBoard_pass());
                    pstmt2.setString(3, board.getBoard_subject());
                    pstmt2.setString(4, board.getBoard_content());
                    pstmt2.setString(5, ""); // 답변에는 파일을 업로드하지 않습니다.
                    pstmt2.setInt(6, re_ref);
                    pstmt2.setInt(7, re_lev);
                    pstmt2.setInt(8, re_seq);
                    pstmt2.setInt(9, 0); // BOARD_READCOUNT(조회수)는 0
                    result = pstmt2.executeUpdate();

                    conn.commit();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("boardReply() 에러 : " + ex);
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException se) {
            System.out.println("DB 연결 오류 발생: " + se.getMessage());
        }

        return result;
    } //boardReply() 메서드 end

    public int boardModify(Board modifyboard) {

        String sql = "update board set BOARD_SUBJECT = ?, BOARD_CONTENT = ? where BOARD_NUM = ?";
        int result = 0;

        try (
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, modifyboard.getBoard_subject());
            pstmt.setString(2, modifyboard.getBoard_content());
            pstmt.setInt(3, modifyboard.getBoard_num());
            result = pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("boardModify() 에러: " + ex);
        }
        return result;
    }

    public Board getDetail(int num) {

        String sql = "select * from board where BOARD_NUM = ?";
        Board board = null;
        try (
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, num);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    board = new Board();
                    board.setBoard_num(rs.getInt("BOARD_NUM"));
                    board.setBoard_pass(rs.getString("BOARD_PASS")); // 비밀번호 확인시 필요합니다.
                    board.setBoard_name(rs.getString("BOARD_NAME"));
                    board.setBoard_subject(rs.getString("BOARD_SUBJECT"));
                    board.setBoard_content(rs.getString("BOARD_CONTENT"));
                    board.setBoard_re_ref(rs.getInt("BOARD_RE_REF"));
                    board.setBoard_re_lev(rs.getInt("BOARD_RE_LEV"));
                    board.setBoard_re_seq(rs.getInt("BOARD_RE_SEQ"));
                    board.setBoard_readcount(rs.getInt("BOARD_READCOUNT"));
                    board.setBoard_date(rs.getString("BOARD_DATE"));

                }
            }
        } catch (Exception ex) {
            System.out.println("getDetail() 에러: " + ex);
        }
        return board;
    } // getDetail() 메서드 end

    public List<Board> getBoardList(int page, int limit) {
        List<Board> list = new ArrayList<>();

        int startrow = (page - 1) * limit + 1;
        int endrow = startrow + limit - 1;

        String board_list_sql = """
                select *
                from (select rownum rnum, BOARD_NUM, BOARD_NAME,
                		           BOARD_SUBJECT, BOARD_CONTENT,
                		           BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ,
                                                   BOARD_READCOUNT, BOARD_DATE
                        from (select * from board
                                order by BOARD_RE_REF desc,
                                BOARD_RE_SEQ asc)
                        where rownum<=?)
                where rnum >= ? and rnum <= ?
                """;
        try (
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
                PreparedStatement pstmt = conn.prepareStatement(board_list_sql);
        ) {

            pstmt.setInt(1, endrow);
            pstmt.setInt(2, startrow);
            pstmt.setInt(3, endrow);

            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    Board board = new Board();
                    board.setBoard_num(rs.getInt("BOARD_NUM"));
                    board.setBoard_name(rs.getString("BOARD_NAME"));
                    board.setBoard_subject(rs.getString("BOARD_SUBJECT"));
                    board.setBoard_content(rs.getString("BOARD_CONTENT"));
                    board.setBoard_re_ref(rs.getInt("BOARD_RE_REF"));
                    board.setBoard_re_lev(rs.getInt("BOARD_RE_LEV"));
                    board.setBoard_re_seq(rs.getInt("BOARD_RE_SEQ"));
                    board.setBoard_date(rs.getString("BOARD_DATE"));

                    list.add(board);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int boardInsert(Board board) {

        String sql = "insert into board values (BOARD_SEQ.NEXTVAL,?,?,?,?, NULL, NULL, BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";

        int rowNum = 0;

        try (
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, board.getBoard_name());
            pstmt.setString(2, board.getBoard_pass());
            pstmt.setString(3, board.getBoard_subject());
            pstmt.setString(4, board.getBoard_content());

            // 원문의 경우 BOARD_RE_LEV, BOARD_RE_SEQ 필드 값은 0 입니다.
            pstmt.setInt(5, 0); //BOARD_RE_LEV 필드
            pstmt.setInt(6, 0); //BOARD_RE_SEQ 필드
            pstmt.setInt(7, 0); //BOARD_READCOUNT 필드
            rowNum = pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("boardInsert() 에러: " + ex);
            ex.printStackTrace();
        }

        return rowNum;
    }
}

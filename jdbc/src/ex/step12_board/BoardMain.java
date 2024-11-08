package ex.step12_board;

import java.util.List;
import java.util.Scanner;

public class BoardMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoardDAO_seq dao = new BoardDAO_seq();
        do {
            int menu = menuselect(sc);
            switch (menu) {
                case 1:
                    insert(sc, dao);
                    break;
                case 2:
                    update(sc, dao);
                    break;
                case 3:
                    reply(sc, dao);
                    break;
                case 4:
                    delete(sc, dao);
                    break;
                case 5:
                    selectAll(dao);
                    break;
                case 6:
                    selectPage(sc, dao);
                    break;
                case 7:
                    search(sc, dao);
                    break;
                case 8:
                    sc.close();
                    return;
            }
        } while (true);
    }

    private static void search(Scanner sc, BoardDAO_seq dao) {
        System.out.print("subject 또는 content 중 검색할 단어를 입력하세요> ");
        List<Board> list = dao.search(sc.nextLine());
        if (list.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            printTitle();
            list.forEach(System.out::println);
        }
    }

    private static void selectPage(Scanner sc, BoardDAO_seq dao) {
        int listcount = dao.count();
        if (listcount > 0) {
            System.out.print("한 페이지에 보여줄 목록을 입력하세요(1~10)> ");
            int limit = inputNumber(sc, 1, 10);
            int maxpage = (listcount -1 ) / limit + 1;
            System.out.print("선택할 페이지를 입력하세요(1~" + maxpage + ") > ");

            int page = inputNumber(sc,1,maxpage);
            List<Board> arrs = dao.getBoardList(page, limit);

            System.out.println("글의 총 개수 : " + listcount);
            printTitle();
            for (Board b : arrs) {
                System.out.println(b.toString());
            }
        } else {
            System.out.println("테이블에 데이터가 없습니다.");
        }
    }

    private static void delete(Scanner sc, BoardDAO_seq dao) {
        System.out.print("삭제할 글 번호를 입력하세요 > ");
        int num = inputNumber(sc);
        Board board = select(dao, num);

        if (board != null) {
            System.out.print("비밀번호  > ");
            String pass = sc.nextLine();
            if (pass.equals(board.getBoard_pass())) {
                int count = dao.boardDelete(board);
                System.out.println(count + "개 삭제되었습니다.");
            } else {
                System.out.println("비밀번호가 다릅니다.");
            }
        }
    }

    private static void reply(Scanner sc, BoardDAO_seq dao) {
        System.out.print("답변을 달 글 번호를 입력하세요 > ");
        int num = inputNumber(sc);
        Board board = select(dao, num);
        if (board != null) {
            System.out.print("글쓴이 > ");
            board.setBoard_name(sc.nextLine());

            System.out.print("제목 > ");
            board.setBoard_subject(sc.nextLine());

            System.out.print("글 내용 > ");
            board.setBoard_content(sc.nextLine());

            System.out.print("비밀번호 > ");
            board.setBoard_pass(sc.nextLine());

            int result = dao.boardReply(board);

            if (result != 0) {
                System.out.println("답글 달기 성공");
            } else {
                System.out.println("답글 달기 실패");
            }
        } else {
            System.out.println("해당 글이 존재하지 않습니다.");
        }
    }

    private static void update(Scanner sc, BoardDAO_seq dao) {
        System.out.print("수정할 글 번호를 입력하세요 > ");
        int num = inputNumber(sc);
        Board board = select(dao, num);
        if (board != null) {
            System.out.print("제목 > ");
            board.setBoard_subject(sc.nextLine());
            System.out.print("글 내용 > ");
            board.setBoard_content(sc.nextLine());
            System.out.print("비밀번호 > ");
            String pass = sc.nextLine();

            // 지금 입력한 비밀번호와 DB에 저장된 비밀번호 비교하기
            if (pass.equals(board.getBoard_pass())) {
                int result = dao.boardModify(board);
                if (result == 1) {
                    dao.boardModify(board);
                    System.out.println("수정에 성공했습니다.");
                } else {
                    System.out.println("수정에 실패했습니다.");
                }
            } else {
                System.out.println("비밀번호가 다릅니다.");
            }
        }

    }

    private static Board select(BoardDAO_seq dao, int num) {
        Board board = dao.getDetail(num);
        if (board != null) {
            printTitle();
            System.out.println(board.toString());
        } else {
            System.out.println("해당 글이 존재하지 않습니다.");
        }
        return board; //수정, 삭제시에는 비밀번호 확인을 위해 필요
        //답변의 경우 원문글(선택한 글)의 BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ 값이 필요
    }

    private static void printTitle() {
        System.out.println("글번호\t작성자\t제목\t내용\tref\tlev\tseq\tdate");
    }

    private static void selectAll(BoardDAO_seq dao) {
        List<Board> boardList = dao.getBoardList(1, 10);
        if (boardList.isEmpty()) {
            System.out.println("테이블에 데이터가 없습니다.");
        } else {
            printTitle();
            for (Board board : boardList) {
                System.out.println(board);
            }
        }

    }

    private static void insert(Scanner sc, BoardDAO_seq dao) {
        Board board = new Board();
        System.out.print("작성자 > ");
        board.setBoard_name(sc.nextLine());
        System.out.print("비밀번호 > ");
        board.setBoard_pass(sc.nextLine());
        System.out.print("제목 > ");
        board.setBoard_subject(sc.nextLine());
        System.out.print("글 내용 > ");
        board.setBoard_content(sc.nextLine());

        if (dao.boardInsert(board) == 1) {
            System.out.println("글이 작성되었습니다.");
        } else {
            System.out.println("오류가 발생되었습니다.");
        }

    }

    private static int menuselect(Scanner sc) {
        String[] menus = {"글쓰기", "수정", "답글달기", "글삭제", "조회", "페이지 선정", "검색", "종료"};
        int i = 0;
        System.out.println("=".repeat(60));
        for (String menu : menus) {
            System.out.println(++i + "." + menu);
        }
        System.out.println("=".repeat(60));
        System.out.print("메뉴를 선택하세요>");
        return inputNumber(sc, 1, menus.length);
    }

    private static int inputNumber(Scanner sc, int start, int end) {
        while (true) {
            try {
                int input = Integer.parseInt(sc.nextLine());
                if ((input <= end && input >= start) || (start == 0 && end == 0)) {
                    return input;
                } else {
                    System.out.print(start + "~" + end + "사이의 숫자를 입력하세요>");
                }
            } catch (NumberFormatException e) {
                System.out.print("숫자로 입력하세요>");
            }
        }
    }

    private static int inputNumber(Scanner sc) {
        return inputNumber(sc, 0, 0);
    }
}

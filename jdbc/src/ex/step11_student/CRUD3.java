package ex.step11_student;

import java.util.ArrayList;
import java.util.Scanner;

public class CRUD3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DAO dao = new DAO();

        do {
            int menu = menuselect(sc);
            switch (menu) {
                case 1:
                    insert(sc, dao);
                    break;
                case 2:
                    select(sc, dao);
                    break;
                case 3:
                    update(sc, dao);
                    break;
                case 4:
                    delete(sc, dao);
                    break;
                case 5:
                    selectAll(dao);
                    break;
                case 6:
                    sc.close();
                    return;
            }
        } while (true);
    }

    private static void delete(Scanner sc, DAO dao) {
        System.out.print("삭제할 번호를 입력하세요 > ");
        int no = inputNumber(sc);
        if (isExist(no, dao)) {
            int result = dao.delete(no);
            if (result == 1)
                System.out.println("삭제 되었습니다.");
            else {
                System.out.println("삭제 되지 않았습니다.");
            }
        } else {
            System.out.println("테이블에 없는 번호입니다.");
        }

    }

    private static boolean isExist(int no, DAO dao) {
        Student3 student = dao.select(no);
        if (student == null) {
            return false;
        }
        return true;
    }

    private static void update(Scanner sc, DAO dao) {
        System.out.print("수정할 번호를 입력하세요 > ");
        int num = sc.nextInt();
        sc.nextLine();
        if (!isExist(num, dao)) {
            System.out.println("테이블에 없는 번호입니다.");
            return;
        }
        System.out.print("이름을 입력하세요 > ");
        String name = sc.nextLine();
        System.out.print("국어점수를 입력하세요 > ");
        int kor = inputNumber(sc, 0, 100);
        System.out.print("수학점수를 입력하세요 > ");
        int math = inputNumber(sc, 0, 100);
        System.out.print("영어점수를 입력하세요 > ");
        int eng = inputNumber(sc, 0, 100);

        Student3 student3 = new Student3(name, kor, math, eng);
        student3.setNo(num);

        int result = dao.update(student3);

        if (result == 1)
            System.out.println("수정이 되었습니다.");
        else
            System.out.println("수정중 오류 발생했습니다.");
    }

    private static void select(Scanner sc, DAO dao) {
        System.out.print("조회할 번호를 입력하세요> ");
        int num = inputNumber(sc);
        Student3 student = dao.select(num);

        if (student != null) {
            printTitle();
            System.out.println(student.toString());
        } else {
            System.out.println("해당 번호로 조회된 학생이 없습니다.");
        }
    }

    private static void printTitle() {

    }

    private static void selectAll(DAO dao) {
        ArrayList<Student3> students = dao.selectAll();
        for (Student3 student : students) {
            System.out.println(student.toString());
        }
    }

    private static int menuselect(Scanner sc) {
        String[] menus = {"입력", "조회", "수정", "삭제", "모두조회", "종료"};
        int i = 0;
        System.out.println("============================================================================");
        for (String menu : menus) {
            System.out.println(++i + "." + menu);
        }
        System.out.println("============================================================================");
        System.out.print("메뉴를 선택하세요>");
        return inputNumber(sc, 1, menus.length);
    }

    private static int inputNumber(Scanner sc) {
        return inputNumber(sc, 0, 0);
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

    private static void insert(Scanner sc, DAO dao) {
        System.out.print("이름을 입력하세요>");
        String name = sc.nextLine();
        System.out.print("국어점수를 입력하세요>");
        int kor = inputNumber(sc, 0, 100);
        System.out.print("수학점수를 입력하세요>");
        int math = inputNumber(sc, 0, 100);
        System.out.print("영어점수를 입력하세요>");
        int eng = inputNumber(sc, 0, 100);
        //객체 생성하면서 tov, avg를 구합니다.
        Student3 student = new Student3(name, kor, math, eng);
        int result = dao.insert(student);

        if (result == 1)
            System.out.println("삽입 되었습니다.");
        else
            System.out.println("삽입 실패되었습니다.");
    }
}

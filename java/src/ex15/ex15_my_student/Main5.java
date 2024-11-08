package ex15.ex15_my_student;

import java.util.ArrayList;
import java.util.Scanner;

public class Main5 {

    public static void main(String args[]) {
        ArrayList<Student5> as = new ArrayList<Student5>();
        input(as);
        Student5.sort(as);
        print(as);
    }

    public static void input(ArrayList<Student5> as) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("이름을 입력하세요> ");
            String name = sc.nextLine();
            System.out.print("국어 점수를 입력하세요> ");
            int kor = inputNumber(sc, 0, 100);
            System.out.print("영어 점수를 입력하세요> ");
            int eng = inputNumber(sc, 0, 100);
            System.out.print("수학 점수를 입력하세요> ");
            int math = inputNumber(sc, 0, 100);
            as.add(new Student5(name, kor, eng, math));
            System.out.print("계속 입력하시겠습니까? (q 또는 Q이면 종료 그외는 계속)" );
            String reply = sc.nextLine();
            if (reply.equals("q") || reply.equals("Q"))
                break;
        }
    }

    public static int inputNumber(Scanner sc, int min, int max) {

        while (true) {
            try {
                String s = sc.nextLine();
                int input = Integer.parseInt(s);
                if (input < min || input > max) {
                    System.out.print(min + "~" + max + "사이의 숫자를 입력하세요> ");
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.out.print("숫자로 입력하세요> ");
            }
        }
    }



    public static void print(ArrayList<Student5> as) {
        System.out.println("========    학생별   /  과목별 총점구하기  =========");
        System.out.println("\t\t국어 영어 수학 총점 평균");
        int length = as.size();
        for (int i = 0; i < length; i++) {
            System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f",as.get(i).name ,as.get(i).kor, as.get(i).eng, as.get(i).math, as.get(i).getTotal(), as.get(i).getAverage());
            System.out.println();
        }
        System.out.println("================================================");
        System.out.println("총점\t\t" + Student5.korTotal + "\t" + Student5.engTotal + "\t" + Student5.mathTotal);
    }
}
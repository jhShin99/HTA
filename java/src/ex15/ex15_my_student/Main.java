package ex15.ex15_my_student;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        System.out.print("학생 수를 입력하세요(최대10명)> ");
        int su = inputNumber(sc);
        Student arr[] = new Student[su];
        input(arr, sc);

        Student.sort(arr);
        printStudent(arr);
    }

    public static void input(Student[] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("======== " + (i+1) + "번째 사람 ========");
            System.out.print("이름을 입력하세요> ");
            String name = sc.nextLine();
            System.out.print("국어 점수를 입력하세요> ");
            int kor = sc.nextInt();
            System.out.print("영어 점수를 입력하세요> ");
            int eng = sc.nextInt();
            System.out.print("수학 점수를 입력하세요> ");
            int math = sc.nextInt();
            sc.nextLine(); // 입력 버퍼 지우기
            Student student = new Student(name, kor, eng, math);
            arr[i] = student;
        }
    }

    public static int inputNumber(Scanner sc) {
        return inputNumber(sc, 1, 10);
    }

    public static int inputNumber(Scanner sc, int min, int max) {

        while (true) {
            try {
                String s = sc.nextLine();
                int input = Integer.parseInt(s);
                if (input < min || input > max) {
                    System.out.print("1~10 사이의 숫자를 입력하세요> ");
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.out.print("숫자로 입력하세요> ");
            }
        }
    }

    public static void printStudent(Student[] arr) {
        System.out.println("========    학생별   /  과목별 총점구하기  =========");
        System.out.println("\t\t국어 영어 수학 총점 평균");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f",arr[i].name,arr[i].kor, arr[i].eng, arr[i].math, arr[i].getTotal(), arr[i].getAverage());
            System.out.println();
        }
        System.out.println("================================================");
        System.out.println("총점\t\t" + Student.korTotal + "\t" + Student.engTotal + "\t" + Student.mathTotal);
    }
}

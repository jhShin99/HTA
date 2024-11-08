package ex06.ex06_array;

public class TwoArrayTest01_5_method2 {

    public static void main(String[] args) {
        String[] name = {"강호동", "이승기", "유재석", "하하", "이광수"};
        String[] sub_name = {"국어", "수학", "영어"};
        int[][] score = {
                {85, 60, 70},
                {90, 95, 80},
                {75, 80, 100},
                {80, 70, 95},
                {100, 65, 80}
        };
        int[] subject = getSubjectTotal(score);
        int[] student = getStudentTotal(score);
        sort(score, student, name);
        print(name, sub_name, score, subject, student);
    }

    private static void sort(int[][] score, int[] student, String[] name) {
        for (int i = 0; i < score.length - 1; i++) {
            for (int j = i + 1; j < score.length; j++) {
                if (student[i] > student[j]) {
                    //이름 변경
                    String imsi1 = name[i];
                    name[i] = name[j];

                    //점수 변경
                    int[] imsi2 = score[i];
                    score[i] = score[j];
                    score[j] = imsi2;

                    //학생별 총점 변경
                    int imsi3 = student[i];
                    student[i] = student[j];
                    student[j] = imsi3;
                }
            }
        }
    }

    private static void print(String[] name, String[] sub_name, int[][] score, int[] subject, int[] student) {

    }

    private static int[] getSubjectTotal(int[][] score) {
        int[] subject = new int[3];
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 3; c++) {
                subject[c] += score[r][c];
            }
        }
        return subject;
    }

    private static int[] getStudentTotal(int[][] score) {
        int[] student = new int[3];
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(score[r][c] + '\t');
                student[r] += score[r][c];
            }
        }
        return student;
    }
}

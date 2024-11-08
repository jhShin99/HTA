package ex18.step5.student6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BufferedSortStudent {
    public static void main(String[] args) {
        ArrayList<Student6> list = new ArrayList<>();
        BufferedReader reader = null;
        input(list);
        Collections.sort(list);
        print(list);
    }

    public static void input(ArrayList<Student6> list) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src/ex18/ex18_buffered/jumsu.txt"));
            while (true) {
                String str = reader.readLine();
                if (str == null)
                    break;
                String[] sep = str.split(" ");
                list.add(new Student6(sep[0], Integer.parseInt(sep[1]), Integer.parseInt(sep[2]), Integer.parseInt(sep[3])));
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다.");
        } catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다.");
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException ioe) {
                ioe.getMessage();
            }
        }
    }

    public static void print(ArrayList<Student6> as) {
        System.out.println("========    학생별   /  과목별 총점구하기  =========");
        System.out.println("\t\t국어 영어 수학 총점 평균");
        int length = as.size();
        for (int i = 0; i < length; i++) {
            System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f",as.get(i).name ,as.get(i).kor, as.get(i).eng, as.get(i).math, as.get(i).getTotal(), as.get(i).getAverage());
            System.out.println();
        }
        System.out.println("================================================");
        System.out.println("총점\t\t" + Student6.korTotal + "\t" + Student6.engTotal + "\t" + Student6.mathTotal);
    }
}

class Student6 implements Comparable<Student6> {

    String name;
    int kor;
    int math;
    int eng;
    static int korTotal;
    static int mathTotal;
    static int engTotal;

    public Student6(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;

        korTotal += kor;
        engTotal += eng;
        mathTotal += math;
    }

    int getTotal() {
        return kor + eng + math;
    }

    float getAverage() {
        return (getTotal() / 3f);
    }


    public String toString() {
        return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + getTotal() + "\t" + getAverage();
    }

    @Override
    public int compareTo(Student6 s) {

        if (getTotal() < s.getTotal())
            return 1;
        else if (getTotal() == s.getTotal())
            return 0;
        else
            return -1;

    }
}
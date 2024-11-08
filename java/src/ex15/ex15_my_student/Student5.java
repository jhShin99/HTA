package ex15.ex15_my_student;

import java.util.ArrayList;

public class Student5 {

    String name;
    int kor;
    int math;
    int eng;
    static int korTotal;
    static int mathTotal;
    static int engTotal;

    public Student5(String name, int kor, int eng, int math) {
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

    float getAverage(){
        return (getTotal() / 3f);
    }

    public static void sort(ArrayList<Student5> as) {
        int num = as.size();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num - 1 - i; j++) {
                if (as.get(j).getTotal() < as.get(j+1).getTotal()) {
                    Student5 imsi = as.get(j);
                    as.set(j, as.get(j+1));
                    as.set(j+1, imsi);
                }
            }
        }
    }

    public String toString() {
        return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + getTotal() + "\t" + getAverage();
    }
}
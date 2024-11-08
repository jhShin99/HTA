package ex15.ex15_student;

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
        for (int i = 0; i < as.size(); i++) {
            for (int j = 0; j < as.size() - 1 - i; j++) {
                if (as.get(j).getTotal() < as.get(j+1).getTotal()) {
                    Student5 imsi = as.get(j);
                    as.set(j, as.get(i));
                    as.set(i, imsi);
                }
            }
        }
    }

    public String toString() {
        return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + getTotal() + "\t" + getAverage();
    }
}
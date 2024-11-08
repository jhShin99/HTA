package ex15.ex15_my_student;

public class Student {

    String name;
    int kor;
    int math;
    int eng;
    static int korTotal;
    static int mathTotal;
    static int engTotal;

    public Student(String name, int kor, int eng, int math) {
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

    public static void sort(Student[] hs) {
        for (int i = 0; i < hs.length - 1; i++) {
            for (int j = 0; j < hs.length - 1 - i; j++) {
                if (hs[j].getTotal() < hs[j+1].getTotal()) {
                    Student imsi = hs[j];
                    hs[j] = hs[j+1];
                    hs[j+1]=imsi;
                }
            }
        }
    }

    public String toString() {
        return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + getTotal() + "\t" + getAverage();
    }
}
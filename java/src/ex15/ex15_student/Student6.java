package ex15.ex15_student;

public class Student6 implements Comparable<Student6>{

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

    float getAverage(){
        return (getTotal() / 3f);
    }



    public String toString() {
        return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + getTotal() + "\t" + getAverage();
    }

//    @Override
//    public int compareTo(Student6 other) {
//        if (this.getTotal() > other.getTotal()) {
//            return -1;
//        } else if (this.getTotal() == other.getTotal()) {
//            return 0;
//        } else {
//            return 1;
//        }
//    }

    //자바 7 이상에서는 Integer.compare()를 사용하여 간결하게 작성할 수 있습니다.
    public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

    //내림차순
    @Override
    public int compareTo(Student6 other) {
        return Integer.compare(other.getTotal(), this.getTotal());
    }
}
package ex15.ex15_hashmap_treemap;

public class Student2 {

    public int sno;
    public String name;

    public Student2(int sno, String name) {
        this.sno = sno;
        this.name = name;
    }

    public String toString() {
        return "[sno=" + sno + " name=" + name + "]";
    }

    // 학번과 이름이 같다면 동일한 값을 리턴하도록 합니다.
        // String은 같은 문자열에 대해서는 hashCode()가 같도록 재정의 되어있습니다.
    public int hashCode() {
        return (sno + name).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Student2) {
            Student2 student = (Student2) obj;
            return (sno == student.sno) && (name.equals(student.name));
        } else {
            return false;
        }
    }

}

package ex21.ex21_ramda_function;

public class Student {
    private String name;
    private int no;

    public Student() {

    }

    public Student(String name, int no) {
        this.name = name;
        this.no = no;
    }

    public String toString() {
        return "name=" + name + ", no=" + no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }
}

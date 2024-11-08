package ex15.ex15_hashmap_treemap;

class Student {
    public int sno; //학번
    public String name; //이름

    public Student(int sno, String name) {
        this.sno = sno;
        this.name = name;
    }

    public String toString() {
        return "[sno=" + sno + " name=" + name + "]";
    }
}

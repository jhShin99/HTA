package ex15.ex15_treeset;

public class Person2 implements Comparable<Person2> {
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    public int hashCode() {
        return (name+age).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Person2) {
            Person2 person = (Person2) obj;
            return this.name.equals(person.name) && this.age == person.age;
        } else {
            return false;
        }
    }
    @Override
    public int compareTo(Person2 p) {
        if (age < p.age) // 부등호의 방향으로 오름차순과 내림차순 결정
            return -1;
        else if (age == p.age)
            return name.compareTo(p.name); // 변경 부분
        else
            return 1;
    }
}

package ex15.ex15_treeset;

public class Person1 implements Comparable<Person1> {
    private String name;
    private int age;

    public Person1(String name, int age) {
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
        if (obj != null && obj instanceof Person1) {
            Person1 person = (Person1) obj;
            return this.name.equals(person.name) && this.age == person.age;
        } else {
            return false;
        }
    }
    @Override
    public int compareTo(Person1 p) {
        if (age < p.age) // 부등호의 방향으로 오름차순과 내림차순 결정
            return -1;
        else if (age == p.age)
            return 0;
        else
            return 1;
    }
}

package ex15.ex15_treeset;

public class Person0 {
    private String name;
    private int age;

    public Person0(String name, int age) {
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

    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Person0) {
            Person0 person = (Person0) obj;
            return this.name.equals(person.name) && this.age == person.age;
        } else {
            return false;
        }
    }
}

package ex13.ex13_object_test;

public class Person implements Cloneable{

    String name;
    int age;
    Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Person) {
            Person person = (Person) obj;
            return this.age == person.age && this.name.equals(person.name) && this.address.equals(person.address);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", address=" + address.toString() + "}";
    }

    @Override
    protected Person clone() {
        try {
            Person copy = (Person) super.clone();
            copy.address = new Address(this.address.street, this.address.city);
            return copy;
        } catch (CloneNotSupportedException e) {
            System.out.println("복제 중 오류 발생");
            return null;
        }
    }
}

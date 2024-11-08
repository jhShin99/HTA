package ex15.wild_test;

public class Child extends Parent{
    String name;

    public Child(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

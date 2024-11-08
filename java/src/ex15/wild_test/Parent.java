package ex15.wild_test;

public class Parent extends GrandParent {
    String name;

    public Parent() {}

    public Parent(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}

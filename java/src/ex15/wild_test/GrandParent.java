package ex15.wild_test;

public class GrandParent {
    String name;

    public GrandParent(){}

    public GrandParent(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}

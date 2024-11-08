package ex13.ex13_object_test;


public class Main {
    public static void main(String[] args) {
        Address address1 = new Address("123 Street", "City");
        Person p1 = new Person("Alice", 30, address1);
        Person p2 = new Person("Alice", 30, address1);
        Person p3 = new Person("Bob", 25, new Address("456 Avenue", "Town"));

        System.out.println(p1.toString());
        Person p4 = p1.clone();
        System.out.println(p4.equals(p1));
        System.out.println(p4.toString());
        System.out.println(p4.address == p1.address);
    }
}

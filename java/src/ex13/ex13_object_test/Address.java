package ex13.ex13_object_test;

public class Address {

    String street;
    String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Address) {
            Address address = (Address) obj;
            return this.street.equals(address.street) && this.city.equals(address.city);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Address{street='" + street + "', city='" + city + "'}";
    }
}

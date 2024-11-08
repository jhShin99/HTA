package ex07.ex07_two_constructor;

import ex07.ex07_object.SubscriberInfo;

public class ConstrExample2_method {

    public static void main(String[] args) {
        SubscriberInfo obj1 = new SubscriberInfo("연흥부", "poorman","zebi");
        obj1.setPhoneNo("010-7777-7777");
        obj1.setAddress("서울시 종로구");
        print(obj1);
        SubscriberInfo obj2 = new SubscriberInfo("연놀부", "richman", "money", "02-123-4567", "강남");
        print(obj2);
    }

    public static void print(SubscriberInfo obj) {
        System.out.println("이름: " + obj.name);
        System.out.println("아이디: " + obj.id);
        System.out.println("패스워드: " + obj.password);
        System.out.println("전화번호: " + obj.phoneNo);
        System.out.println("주소: " + obj.address);
        System.out.println();
    }
}

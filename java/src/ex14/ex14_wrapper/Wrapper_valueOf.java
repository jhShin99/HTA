package ex14.ex14_wrapper;

public class Wrapper_valueOf {

    public static void main(String[] args) {
        //Wrapper 클래스의 생성자를 대신하는 정적 메서드
        //박싱 - 기본형 타입의 값을 객체화
        //int -> Integer
        Integer obj1 = Integer.valueOf(10);
        Integer obj2 = Integer.valueOf(10);

        if (obj1==obj2)
            System.out.println("obj1==obj2");
        else
            System.out.println("obj1!=obj2");

        if (obj1.equals(obj2))
            System.out.println("obj1.equals(obj2) 같아요");
        else
            System.out.println("obj1.equals(obj2) 달라요");

    }
}

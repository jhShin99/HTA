package ex13.ex13_object_hashcode;

public class ObjectExample {

    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = new String("abc");

        //String 클래스는 문자열의 내용이 같으면 동일한 해시코드를 반환하도록
        //hashCode 메서드가 오버라이딩 되어 있기 때문에
        //문자열의 내용이 같은 str1과 str2에 대해 hashCode()를 호출하면
        //항상 동일한 해시코드값을 얻습니다.
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
    }
}

package ex11.ex11_string;

public class StringExample8 {

    public static void main(String[] args) {
        String message = "Java program creates many objects.";

        //지정한 문자가 최초로 위치한 인덱스를 구합니다.
        //존재하지 않는
        int index = message.indexOf('a');
        System.out.println("a의 위치는 " + index);

        //지정된 문자가 최초로 위치한 인덱스를 구합니다.
        int index2 = message.indexOf(97);
        System.out.println("a의 위치는 " + index2);

        //아스키코드 65은 대문자 'A'
        int index23 = message.indexOf(65);
        //'A'가 없을 때는 index 값은 -1을 반환합니다.
        System.out.println("A의 위치는 " + message.indexOf('A'));

        // "av"의 시작 index를 찾습니다.
        int index4 = message.indexOf("av");
        System.out.println("av로 시작하는 index는 " + index4);

        //index 번호 12번째 부터 "man"의 시작 index를 찾습니다.
        int index5 = message.indexOf("man", 12);
        System.out.println("12번째 부터 man위치는 " + index5);



    }
}

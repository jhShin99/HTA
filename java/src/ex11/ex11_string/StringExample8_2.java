package ex11.ex11_string;

public class StringExample8_2 {

    public static void main(String[] args) {
        String message = "Java program creates many objects.";

        int index = message.lastIndexOf('a');
        System.out.println("a의 위치는 " + index);

        int index2 = message.lastIndexOf(97);
        System.out.println("a의 위치는 " + index2);

        int index23 = message.lastIndexOf(65);
        System.out.println("A의 위치는 " + message.lastIndexOf('A'));

        int index4 = message.lastIndexOf('a', 13);
        System.out.println("13번부터 a의 위치는 " + index4);

    }
}

package ex21.ex21_ramda_function;

public class ConsumerExample2 {

    public static void main(String[] args) {
        Box box = new Box();
        box.add("홍길동");
        box.add("hta");
        box.add("자바");

        //람다식
        box.forEach((i)-> System.out.println(i));

        //메서드 참조
        box.forEach(System.out::println);
    }
}

package ex06.ex06_method;

public class MethodExample9 {

    public static void main(String[] args) {
        int num = 50;
        char data = '*';
        print(num, data);
    }

    public static void print(int p_num, char p_data) {
        System.out.println("print() 메서드 입니다.");
        System.out.println("main() 메서드에서 전달받은 데이터의 값은 " + p_num + "," + p_data + "입니다.");
    }
}

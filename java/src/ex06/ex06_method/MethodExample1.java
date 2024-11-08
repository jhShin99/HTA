package ex06.ex06_method;

//사용자가 정의한 메서드를 실행할 수 있도록 합니다.
//이것을 메서드 호출이라고 합니다.
//즉 메서드를 호출하면 해당 메서드를 실행합니다.
public class MethodExample1 {
    //접근제어자   객체생성없이 접근가능   반환되는 값의 자료형   메서드이름(매개변수 목록)
    public        static              void                   main(String[] args) {
        print(); // 메서드 호출
        print(); // 메서드 호출
        return;
    }

    // 메서드 정의
    public static void print() {
        System.out.println("print() 메서드 입니다.");
    }
}

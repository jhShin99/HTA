package ex07.ex07_singleton;

public class Singleton {

    //필드 s는 외부에서 사용 못합니다.
    //이 문장은 처음 Singleton 클래스가 JVM에 로딩될 때 한 번만 실행됩니다.
    private static Singleton s = new Singleton();

    //외부에서 생성자를 호출할 수 없도록 막습니다.
    private Singleton(){}

    public static Singleton getInstance() {
        System.out.println("여기는 getInstance입니다.");
        return s;
    }

}

package ex15.ex15_generic_method_box;

public class Util {
    /**
     * 제네릭 메서드는 매개 타입과 리턴 타입으로 타입 파라미터를 갖는 메서드입니다.
     * 리턴 타입 앞에 <>를 추가하고 타입 파라미터를 기술합니다.
     */
    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<T>();
        box.set(t);
        return box;
    }
}

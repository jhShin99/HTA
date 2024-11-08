package ex15.ex15_generic_method_box;

/**
 * 제네릭 타입 class<T>
 * class 뒤에 <T>를 추가합니다.
 * Object -> T로 변경
 */
public class Box<T> {
    private T object;

    public void set(T object) {
        this.object = object;
    }

    public T get() {
        return object;
    }
}

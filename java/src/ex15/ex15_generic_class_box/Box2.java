package ex15.ex15_generic_class_box;

/**
 * 제네릭 타입 class<T>
 * 1. class 뒤에 <T>를 추가합니다.
 * 2. Object -> T로 변경
 * 3. Box<T> : 지네릭 클래스, 'T의 박스' 또는 'T Box'라고 읽습니다.
 * 4. T      : 타입 변수 또는 타입 매개 변수라고 합니다.
 * 5. Box    : 원시 타입(raw type)
 */
public class Box2<T> {
    private T object;

    public void set(T object) {
        this.object = object;
    }

    public T get() {
        return object;
    }
}

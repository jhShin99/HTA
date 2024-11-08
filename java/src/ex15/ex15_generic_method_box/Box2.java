package ex15.ex15_generic_method_box;

import java.util.Map;

/**
 * 제네릭 타입 class<T>
 * class 뒤에 <T>를 추가합니다.
 * Object -> T로 변경
 */
public class Box2<K,V> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

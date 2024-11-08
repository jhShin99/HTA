package ex15.ex15_generic_class_box;

/**
 * 멀티 타입 파라미터
 * class 뒤에 <K, V>를 추가합니다.
 * Object -> K, V로 변경
 */
public class Box3<K, V> {
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

    @Override
    public String toString() {
        return "Box [key=" + key + ", value=" + value + "]";
    }
}

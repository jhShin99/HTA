package ex15.ex15_generic_method_box;

public class Util2 {

    /**
     * 제네릭 메서드는 매개 타입과 리턴 타입으로 타입 파라미터를 갖는 메서드입니다.
     * 리턴 타입 앞에 <>를 추가하고 타입 파라미터를 기술합니다.
     */
    public static <K,V> Box2<K,V> boxing(K k, V v) {
        Box2<K,V> box = new Box2<K, V>();
        box.setKey(k);
        box.setValue(v);
        return box;
    }
}

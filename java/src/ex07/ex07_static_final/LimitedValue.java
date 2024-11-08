package ex07.ex07_static_final;

public class LimitedValue {

    static final int UPPER_LIMIT = 100000;
    int value;

    void setValue(int value) {
        if (value < UPPER_LIMIT)
            this.value = value;
        else
            this.value = UPPER_LIMIT; // 상수 필드의 사용
    }
}

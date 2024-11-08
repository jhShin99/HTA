package ex21.ex21_ramda_new;

@FunctionalInterface // 두 개 이상의 추상메소드가 선언되면 컴파일 오류를 발생시킵니다.
public interface ArrayExample {
    int[] toArray(int size);
}

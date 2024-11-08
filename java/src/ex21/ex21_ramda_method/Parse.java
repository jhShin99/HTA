package ex21.ex21_ramda_method;

@FunctionalInterface //두 개 이상의 추상 메소드가 선언되면 컴파일 오류를 발생시킵니다.
public interface Parse {
    int toInt(String x);
}

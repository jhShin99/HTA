package ex11.ex11_math;

public class MathExample1 {

    public static void main(String[] args) {
        System.out.println("12.45 반올림 => " + Math.round(12.45)); //12
        System.out.println("124.5 반올림 => " + Math.round(124.5)); //125

        //12.45를 반올림해서 12.5로 만들어 보세요.
        System.out.println(Math.round(12.45*10)); //125
        System.out.println(Math.round(12.45*10)/10.0); //12.5
    }
}

package ex14.ex14_wrapper;

public class Wrapper2_String_to_int {

    public static void main(String[] args) {
        int total = 0;

        //방법1.
        // String -> Integer 객체
        for (int cnt = 0; cnt < args.length; cnt++) {
            System.out.println("args[" + cnt + "]= " + args[cnt]);

            Integer obj = Integer.valueOf(args[cnt]);
            total += obj.intValue();
        }
        System.out.println("합 = "  + total);

        int total2 = 0;
        for (int cnt = 0; cnt < args.length; cnt++) {
            total2 += Integer.parseInt(args[cnt]);
        }
        System.out.println("합 = " + total2);
    }


}

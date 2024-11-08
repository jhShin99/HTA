package ex06.ex06_array;

public class ArrayExample5_String {

    public static void main(String[] args) {
        System.out.println("=====방법1=====");
        String[] name = new String[3];
        name[0] = "홍길동";
        name[1] = "이순신";
        name[2] = "세종대왕";
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i]);
        }

        System.out.println("=====방법2=====");
        String[] name2 = new String[]{"홍길동", "이순신", "세종대왕"};
        for (int i = 0; i < name2.length; i++) {
            System.out.println(name2[i]);
        }

        System.out.println("=====방법3=====");
        String[] name3 = {"홍길동", "이순신", "세종대왕"};
        for (int i = 0; i < name3.length; i++) {
            System.out.println(name3[i]);
        }
    }
}

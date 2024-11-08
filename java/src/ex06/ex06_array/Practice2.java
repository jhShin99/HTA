package ex06.ex06_array;

public class Practice2 {

    public static void main(String[] args) {
        int[] score = new int[5];
        score[0]=95; score[1]=70; score[2]=80; score[3]=75; score[4]=100;
        int sum = 0;
        for (int x : score) {
            sum += x;
        }
        System.out.println(sum);
    }
}

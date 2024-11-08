package ex07.ex07_private_field;

public class Numbers {

    private int[] num;

    Numbers(int[] num) {
        this.num = num;
    }

    int getTotal() {
        int sum = 0;
        for (int n : num) {
            sum += n;
        }
        return sum;
    }

    int getAverage() {
        return getTotal()/num.length;
    }
}

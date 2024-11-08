package ex15.ex15_hashset;

import java.util.HashSet;
import java.util.Random;

public class HashSet_Generics_Lotto {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        int num;
        Random random = new Random();
        for (int i = 0; set.size() < 6; i++) {
            num = random.nextInt(45)+1;
            set.add(num);
        }

        System.out.println(set);

    }
}

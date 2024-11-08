package ex21.ex21_ramda_function;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Box {
    private ArrayList<String> list = new ArrayList<>();

    public Box()  {

    }

    public void add(String inputdata) {
        list.add(inputdata);
    }

    public void forEach(Consumer<? super String> action) {
        for (String eachData : list) {
            action.accept(eachData);
        }
    }
}

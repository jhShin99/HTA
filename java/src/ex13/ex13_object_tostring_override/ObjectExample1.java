package ex13.ex13_object_tostring_override;

public class ObjectExample1 {

    public static void main(String[] args) {
        GoodsStock obj = new GoodsStock("57293", 100);
        String str = obj.toString();
        System.out.println(str);
    }
}
